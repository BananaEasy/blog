package xyz.lihang.blog.quartz.quartz;

import com.alibaba.fastjson.JSON;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xyz.lihang.blog.mapper.entity.Article;
import xyz.lihang.blog.service.service.IArticleManagerService;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class ArticleLuceneQuartz {

    private enum articleEnum {
        articleId("articleId"),
        articleTitle("articleTitle"),
        articleJson("articleJson");
        private String name;
        articleEnum(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    private IndexWriter indexWriter;

    @Resource
    public void setIndexWriter(IndexWriter indexWriter) {
        this.indexWriter = indexWriter;
        createIndex();
    }

    @Resource
    private IArticleManagerService articleManagerService;

    private Logger logger = Logger.getLogger(ArticleLuceneQuartz.class.getName());

    //建立索引
    @Scheduled(cron = "0 0 0/2 1/1 * ? ") //每两个小时建立一次索引 //同步防止在启动的时候建立索引因为文件锁的问题
    public synchronized void createIndex () {
        try {
            indexWriter.deleteAll();
            List<Article> articles = articleManagerService.selectAll();
            //拿到article
            for(Article article : articles){
                Document document = new Document();
                document.add(new Field(articleEnum.articleId.name,article.getId().toString(), TextField.TYPE_STORED));
                document.add(new Field(articleEnum.articleTitle.name,article.getArticletitle(),TextField.TYPE_STORED));
                document.add(new Field(articleEnum.articleJson.name,JSON.toJSONString(article),TextField.TYPE_STORED));
                indexWriter.addDocument(document);
            }
            logger.info("新建立索引个数:"  + articles.size());
            indexWriter.commit();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private Analyzer analyzer;

    /**
     * 采用吧所有数据查出来再分页 可能导致内存剧增
     * @param search
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Deprecated
    public List<Article> searchArticleTitle(String search,int currentPage,int pageSize){
        IndexReader indexReader = applicationContext.getBean(IndexReader.class);
        List<Article> list = new ArrayList<>();
        try {

            IndexSearcher searcher = new IndexSearcher(indexReader);
            //4、创建索引的Query
            //第二个参数代表着要搜索的域
            Query query = new TermQuery(new Term(articleEnum.articleTitle.name,search));
            //QueryParser parser = new QueryParser(Version.LUCENE_7_1_0,);
            //表示搜索content中包含java的文档
            //Query query = parser.parse(search);
            //表示返回前面10条
            TopDocs topDocs = searcher.search(query,100);
            //6、根据TopDocs获取ScoreDoc对象
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            //查询起始记录位置
            int begin = Math.max(pageSize * (currentPage - 1),0);
            //查询终止记录位置
            int end = Math.min(begin + pageSize, scoreDocs.length);
            for(int i = begin;i<end;i++){
                //7、根据Searcher和ScordDoc对象获取具体的Document对象
                //获取这个文档的id
                Document document = searcher.doc(scoreDocs[i].doc);
                //8、根据Document对象获取需要的值
                list.add(JSON.parseObject(document.get(articleEnum.articleJson.name),Article.class));
            }

        }catch (Exception e){
            logger.info("error:" + e.getMessage());
        }finally {
            try {
                indexReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 保险的分页方式
     * @param search
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Map<String,Object> searchArticleTitleAfter(String search, int currentPage, int pageSize){
        IndexReader indexReader = applicationContext.getBean(IndexReader.class);
        List<Article> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>(2);
        try {
            IndexSearcher searcher = new IndexSearcher(indexReader);
            //4、创建索引的Query
            //第二个参数代表着要搜索的域
            //指定搜索字段和分析器
            QueryParser parser=new QueryParser(articleEnum.articleTitle.name, analyzer);
            //用户输入内容
            Query query=parser.parse(search);
            //获取上一页的最后一个元素
            ScoreDoc lastSd = getLastScoreDoc(currentPage, pageSize, query, searcher);
            //通过最后一个元素去搜索下一页的元素
            TopDocs tds = searcher.searchAfter(lastSd,query, pageSize);
            QueryScorer scorer=new QueryScorer(query);
            Fragmenter fragmenter=new SimpleSpanFragmenter(scorer);
            SimpleHTMLFormatter simpleHTMLFormatter=new SimpleHTMLFormatter("<b><font color='red'>","</font></b>");
            Highlighter highlighter=new Highlighter(simpleHTMLFormatter, scorer);
            highlighter.setTextFragmenter(fragmenter);
            for(ScoreDoc sd:tds.scoreDocs) {
                Document doc = searcher.doc(sd.doc);
                String articleTitle = doc.get(articleEnum.articleTitle.name);
                Article article = JSON.parseObject(doc.get(articleEnum.articleJson.name),Article.class);
                 if(articleTitle!=null){
                    TokenStream tokenStream=analyzer.tokenStream(articleEnum.articleTitle.name, new StringReader(articleTitle));
                    article.setArticletitle(highlighter.getBestFragment(tokenStream, articleTitle));
                 }
                list.add(article);
            }
            map.put("total",tds.totalHits);
            map.put("list",list);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("error:" + e.getMessage());
        }finally {
            try {
                indexReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * 根据页码和分页大小获取上一次的最后一个scoredocs
     * @param pageIndex
     * @param pageSize
     * @param query
     * @param searcher
     * @return
     * @throws IOException
     */
    private ScoreDoc getLastScoreDoc(int pageIndex,int pageSize,Query query,IndexSearcher searcher) throws IOException {
        if(pageIndex==1)return null;//如果是第一页就返回空
        int num = pageSize*(pageIndex-1);//获取上一页的最后数量
        TopDocs tds = searcher.search(query, num);
        return tds.scoreDocs[num-1];
    }


}


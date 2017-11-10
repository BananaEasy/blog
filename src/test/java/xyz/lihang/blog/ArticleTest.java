package xyz.lihang.blog;

import com.alibaba.fastjson.JSON;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.lihang.blog.mvc.entity.Article;
import xyz.lihang.blog.mvc.quartz.ArticleLuceneQuartz;
import xyz.lihang.blog.mvc.service.IArticleManagerService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTest {
    //索引目录
    private String derictoryName = "F:\\article";

    @Resource
    private IArticleManagerService articleManagerService;

    Logger logger = Logger.getLogger(ArticleTest.class.getName());

    @Resource
    IndexWriter indexWriter ;

    @Resource
    ArticleLuceneQuartz articleLuceneQuartz;

    //添加索引
    @Test
    public void addDom() throws Exception{
        //1、创建Directory
        List<Article> articles = articleManagerService.selectAll();
        indexWriter.deleteAll();
//        //拿到article
//        for(Article article : articles){
//            Document document = new Document();
//            document.add(new TextField("articleId",article.getId().toString(),Field.Store.NO));
//            document.add(new TextField("articleTitle",article.getArticletitle(),Field.Store.YES));
//            document.add(new TextField("article", JSON.toJSONString(article),Field.Store.NO));
//            indexWriter.addDocument(document);
//            logger.info(article.getId().toString());
//        }
        articleLuceneQuartz.createIndex();
        indexWriter.commit();
        Map<String, Object> map =articleLuceneQuartz.searchArticleTitleAfter("四大王者",1,5);
        for(Article articl : (List<Article>) map.get("list")){
            logger.info(articl.getArticletitle());
        }
        logger.info("=================1==================");

        map = articleLuceneQuartz.searchArticleTitleAfter("四大王者", 2, 20);
        for(Article articl : (List<Article>) map.get("list")){
            logger.info(articl.getArticletitle());
        }
//
//        logger.info("=================1==================");
//        search ();
//
//
//        indexWriter.commit();
//
//        logger.info("================2===================");
//        search ();
//
//        indexWriter.deleteAll();
//        logger.info("=================3==================");
//        search ();
//        indexWriter.commit();
//
//        logger.info("==================4=================");
//        search ();

    }

    @Resource
    ApplicationContext applicationContext;

    @Test
    public void search ()throws Exception{
        IndexReader indexReader = applicationContext.getBean(IndexReader.class);
        logger.info("地址" + indexReader.hashCode());
        IndexSearcher searcher = new IndexSearcher(indexReader);
        //4、创建索引的Query
        //第二个参数代表着要搜索的域
        QueryParser parser = new QueryParser("articleTitle",new StandardAnalyzer());
        //表示搜索content中包含java的文档
        Query query = parser.parse("四大王者");
        //表示返回前面10条
        TopDocs topDocs = searcher.search(query,10);
        //6、根据TopDocs获取ScoreDoc对象
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for(ScoreDoc sd : scoreDocs){
            //7、根据Searcher和ScordDoc对象获取具体的Document对象
            //获取这个文档的id
            int doc = sd.doc;
            Document document = searcher.doc(doc);
            //8、根据Document对象获取需要的值
            logger.info("【找到】" + document.get("articleId") + "    " + document.get("articleTitle") );
        }
        indexReader.close();
    }




}

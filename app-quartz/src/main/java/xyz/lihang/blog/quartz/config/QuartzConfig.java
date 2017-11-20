package xyz.lihang.blog.quartz.config;

import com.alibaba.fastjson.JSON;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import xyz.lihang.blog.common.tool.JsonPares;
import xyz.lihang.blog.common.tool.utils.PathUtils;
import xyz.lihang.blog.mapper.model.SiteMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Logger;

@Configuration
@ComponentScan
public class QuartzConfig {

    private Logger logger = Logger.getLogger(QuartzConfig.class.getName());

    public static String seoJsonPath = PathUtils.getClassesPath()
            + File.separator  + "json"
            +File.separator  + "SiteMap.json";

    public static SiteMap getSiteMap() {
        String json = JsonPares.readFileToString(seoJsonPath);
        return JSON.parseObject(json,SiteMap.class);
    }

    //=====================
    // lucene 配置
    //
    @Bean
    public Directory directory() throws IOException {
        //derictoryName ： classes/lucene
        String derictoryName = null;
        try {
            derictoryName =  PathUtils.getClassesPath() + File.separator  + "lucene";
        }catch (Exception e){
            derictoryName = "F:\\article";
        }
        logger.info("lucene索引路径：" + derictoryName);
        return FSDirectory.open( Paths.get(derictoryName));
    }

    @Bean
    public IndexWriter indexWriter(Directory directory, Analyzer analyzer)throws IOException{
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        IndexWriter writer = new IndexWriter(directory,config);
        writer.commit();
        return writer;
    }
    //多例的
    @Bean
    @Scope("prototype")
    public IndexReader indexReader(Directory directory)throws IOException{
        IndexReader reader = DirectoryReader.open(directory);
        return reader;
    }

    //分词器
    @Bean
    public Analyzer StandardAnalyzer(){
        return new StandardAnalyzer();
    }


}

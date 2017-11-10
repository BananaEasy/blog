package xyz.lihang.blog.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import xyz.lihang.blog.mvc.controller.BaseController;
import xyz.lihang.blog.tool.utils.PathUtils;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 */
@SpringBootConfiguration
public class ApplicationConfig {

    private Logger logger = Logger.getLogger(ApplicationConfig.class.getName());



    //mapper 配置
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));

        //添加插件
        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(new Properties());
        sqlSessionFactoryBean.setPlugins(new Interceptor[] {pageInterceptor});

        //扫描Entity
        sqlSessionFactoryBean.setTypeAliasesPackage("xyz.lihang.blog.mvc.entity");
        return sqlSessionFactoryBean.getObject();
    }

    //=====================
    // lucene 配置
    //
    @Bean
    public Directory directory() throws IOException{
        //derictoryName ： classes/lucene
        String derictoryName = null;
        try {
            derictoryName =  PathUtils.getClassesPath() + File.separator  + "lucene";
        }catch (Exception e){
            derictoryName = "F:\\article";
        }
        //String derictoryName = "F:\\article";
        logger.info("lucene索引路径：" + derictoryName);
        return FSDirectory.open( Paths.get(derictoryName));
    }


    @Bean
    public IndexWriter indexWriter(Directory directory,Analyzer analyzer)throws IOException{
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
        //return new SmartChineseAnalyzer();
    }

}

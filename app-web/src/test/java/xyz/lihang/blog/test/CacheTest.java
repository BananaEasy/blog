package xyz.lihang.blog.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.lihang.blog.mapper.entity.Article;

import javax.annotation.Resource;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {

    public static Logger logger = Logger.getLogger(CacheTest.class.getName());

    @Resource
    private CacheDemo cacheDemo;

    @Test
    public void test(){
        logger.info("test:" + cacheDemo.find("1"));
        logger.info("test:" +cacheDemo.find("2"));
        logger.info("test:" +cacheDemo.find("1"));
    }
    public static Article db(String id){
        logger.info("db...");
        Article article = new Article();
        article.setId(Integer.parseInt(id));
        return article;
    }
}

@Component
class CacheDemo {
    @Cacheable(value="articleCache",key = "#id")
    public Article find(String id){
        CacheTest.logger.info("find method..." + id);
        return CacheTest.db(id);
    }
}

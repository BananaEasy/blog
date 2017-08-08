package com.blog.thread;

import com.blog.mvc.cache.FreemakerCache;
import com.blog.mvc.dao.ArticleMapper;
import com.blog.mvc.entity.AccessRecord;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by LiHang on 2017/8/7.
 *
 * 定时任务类
 */
@Component
@Lazy(false)
public class QuartzHandleCache {
    @Resource
    private FreemakerCache freemakerCache;

    @Resource
    private ArticleMapper articleMapper;

    Log log = LogFactory.getLog(getClass());

    public QuartzHandleCache(){
        log.info("创建缓存刷新定时任务");
    }




    //刷新缓存
    @Scheduled(cron = "0 0/20 * * * ? ")//每隔20分钟执行一次
    public void refreshCache()  {
        log.info("执行缓存刷新方法");
        freemakerCache.refresh();
    }


    private static  Queue<Integer> articleIds = new ConcurrentLinkedDeque<Integer>();

    public static void addArticleId (Integer id){
        articleIds.add(id);
    }
    public static Integer getAarticleId(){
        // 获取并移除此队列的头，如果此队列为空，则返回 null
        return articleIds.poll();
    }

    @Scheduled(cron = "0/1 * * * * ? ")//每隔1s执行一次
    //每次处理五个任务
    public void addCount (){
        try{
            for(int i=0;i<5;i++){
                Integer aarticleId = getAarticleId();
                if( null != aarticleId ){
                    log.info("aarticleId:" + aarticleId + "执行count++");
                    articleMapper.addArticleCount(aarticleId);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

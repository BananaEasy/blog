package com.blog.quartz;

import com.blog.mvc.cache.FreemakerCache;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * Created by LiHang on 2017/8/7.
 *
 * Freemarker缓存刷新定时任务类
 */
@Component
@Lazy(false)
public class FreemakerCacheQuartz {
    @Resource
    private FreemakerCache freemakerCache;


    Log log = LogFactory.getLog(getClass());

    public FreemakerCacheQuartz(){
        log.info("创建缓存刷新定时任务");
    }


    //刷新缓存
    @Scheduled(cron = "0 0/20 * * * ? ")//每隔20分钟执行一次
    public void refreshCache()  {
        try {
            log.info("刷新Freemarker共享缓存" );
            freemakerCache.refresh();
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }


}

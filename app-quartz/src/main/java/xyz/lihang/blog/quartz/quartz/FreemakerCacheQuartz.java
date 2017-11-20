package xyz.lihang.blog.quartz.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * Created by LiHang on 2017/8/7.
 *
 * Freemarker缓存刷新定时任务类
 */
@Component
public class FreemakerCacheQuartz {
    @Resource
    private BlogCacheManager blogCacheManager;

    private Logger log = Logger.getLogger(getClass().getName());

    public FreemakerCacheQuartz(){
        log.info("创建缓存刷新定时任务");
    }


    //刷新缓存
    @Scheduled(cron = "0 0/20 * * * ? ")//每隔20分钟执行一次
    public void refreshCache()  {
        try {
            log.info("刷新Freemarker共享缓存" );
            blogCacheManager.refreshFreemakerCache();
        }catch (Exception e){
            log.fine(e.getMessage());
        }
    }


}

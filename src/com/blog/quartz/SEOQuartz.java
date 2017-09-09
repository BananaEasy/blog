package com.blog.quartz;

import com.blog.tool.seo.ExtWebSiteMapUrl;
import com.blog.tool.seo.HtmlCrawler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
@Lazy(false)
public class SEOQuartz {
    Log log = LogFactory.getLog(getClass());
    public SEOQuartz(){
        log.info("siteMap自动生成初始化成功");
    }
    //刷新缓存
    @Scheduled(cron = "0 0 0 1/1 * ? ")//每天执行一次
    public void refreshSiteMap()  {
        try {
            ExtWebSiteMapUrl startUrl = HtmlCrawler.getStartUrl();
            Queue<ExtWebSiteMapUrl> queue = new LinkedList<ExtWebSiteMapUrl>();
            queue.add(startUrl);
            HtmlCrawler.crawl(queue, HtmlCrawler.wsg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

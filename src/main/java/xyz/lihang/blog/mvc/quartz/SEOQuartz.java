package xyz.lihang.blog.mvc.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xyz.lihang.blog.tool.seo.ExtWebSiteMapUrl;
import xyz.lihang.blog.tool.seo.HtmlCrawler;

import java.util.LinkedList;
import java.util.Queue;

@Component
public class SEOQuartz {
    Logger log = LoggerFactory.getLogger(((getClass())));
    public SEOQuartz(){
        log.info("siteMap自动生成初始化成功");
    }
    //刷新缓存
    @Scheduled(cron = "0 0 0 1/1 * ? ")//每天执行一次
    public void refreshSiteMap()  {
        try {
            HtmlCrawler.create();
            ExtWebSiteMapUrl startUrl = HtmlCrawler.getStartUrl();
            Queue<ExtWebSiteMapUrl> queue = new LinkedList<ExtWebSiteMapUrl>();
            queue.add(startUrl);
            HtmlCrawler.crawl(queue, HtmlCrawler.wsg);
            log.info("siteMap刷新成功");
        }catch (Exception e){
            e.printStackTrace();
            log.info("siteMap刷新失败");
        }
    }
}

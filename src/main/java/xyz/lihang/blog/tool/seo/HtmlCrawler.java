package xyz.lihang.blog.tool.seo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import xyz.lihang.blog.model.SiteMap;
import xyz.lihang.blog.mvc.Constant;
import com.redfin.sitemapgenerator.ChangeFreq;
import com.redfin.sitemapgenerator.W3CDateFormat;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TimeZone;

/**
 * siteMap生成
 */
public class HtmlCrawler {



    public static File dir = null;
    public static String basePrefix = null;
    public static String mainUrl = null;

    public static NodeClassFilter LINK_FILTER = new NodeClassFilter(LinkTag.class);
    public static Parser parser = new Parser();
    public static WebSitemapGenerator wsg = null;
    private static Logger log = LoggerFactory.getLogger(HtmlCrawler.class);
    private static SiteMap siteMap;


    /**
     *
     */
    public static void create (){
        siteMap = Constant.getSiteMap();
        dir =new File(siteMap.getDir());
        File temp = new File (dir + "sitemap.xml");
        if(temp.exists()){
            temp.delete();
        }
        basePrefix = siteMap.getBasePrefix();
        mainUrl = siteMap.getMainUrl();

        W3CDateFormat dateFormat = new W3CDateFormat(W3CDateFormat.Pattern.DAY);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        try {
            wsg = WebSitemapGenerator.builder(basePrefix, dir).dateFormat(
                    dateFormat).build();
        } catch (MalformedURLException e) {
            log.info("the start url [" + basePrefix
                    + "] is malformed");
        }
    }

    public static ExtWebSiteMapUrl getStartUrl() throws Exception{
        return new ExtWebSiteMapUrl(
                new WebSitemapUrl.Options(mainUrl).lastMod(
                        new Date()).priority(0.9).changeFreq(ChangeFreq.WEEKLY));
    }

    /** *//**
     * 检测是否为同一个域下的url
     *
     * @param url
     * @param basePrefix
     * @return
     */
    public static boolean check(String url, String basePrefix) {
        if(StringUtils.isNotBlank(url)){
            String[] filter = siteMap.getFilter();
            if(filter != null && filter.length != 0){
                for(String s :filter){
                    if(url.contains(s)){
                        return false;
                    }
                }
            }
            log.info(url);
            return url.startsWith(basePrefix);
        }else{
            return false;
        }
    }

    /** *//**
     * 使用队列循环抓取页面上的URL
     *
     * @param queue
     * @param wsg
     */
    public static void crawl(Queue<ExtWebSiteMapUrl> queue,
                             WebSitemapGenerator wsg) {
        if (CollectionUtils.isEmpty(queue)) {
            return;
        }
        Queue<ExtWebSiteMapUrl> crawled = new LinkedList<ExtWebSiteMapUrl>();
        do {
            ExtWebSiteMapUrl url = queue.poll();
            crawled.add(url);
            if (url != null && url.canCrawl()) {
                try {
                    parser.setURL(url.getUrl().toExternalForm());
                    NodeList list = parser.parse(LINK_FILTER);
                    for (NodeIterator iter = list.elements(); iter
                            .hasMoreNodes();) {
                        String link = ((LinkTag) iter.nextNode()).getLink();
                        ExtWebSiteMapUrl newUrl = null;
                        try {
                            newUrl = new ExtWebSiteMapUrl(
                                    new WebSitemapUrl.Options(link).lastMod(
                                            new Date()).priority(0.7)
                                            .changeFreq(ChangeFreq.WEEKLY));
                        } catch (MalformedURLException e) {
                            log.info("the url [" + link
                                    + "] is malformed");
                            continue;
                        }
                        if (check(link, basePrefix) && !queue.contains(newUrl)
                                && !crawled.contains(newUrl)) {
                            queue.add(newUrl);
                            wsg.addUrl(newUrl);
                        }
                    }
                } catch (ParserException e) {
                    log.info("can not parser the url : "
                            + url.getUrl());
                } finally {
                    url.disable();
                }
            }
        } while (queue.size() > 0);

        wsg.write();
    }
}
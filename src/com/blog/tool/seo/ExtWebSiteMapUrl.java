package com.blog.tool.seo;

import org.apache.commons.lang.StringUtils;

import com.redfin.sitemapgenerator.WebSitemapUrl;

public class ExtWebSiteMapUrl extends WebSitemapUrl implements CrawlUrl {

    public ExtWebSiteMapUrl(Options options) {
        super(options);
    }

    private boolean canCrawl = true;

    @Override
    public boolean canCrawl() {
        return canCrawl;
    }

    @Override
    public void disable() {
        canCrawl = false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof ExtWebSiteMapUrl) {
            ExtWebSiteMapUrl url = (ExtWebSiteMapUrl) obj;
            return StringUtils.equals(url.getUrlStr(), getUrlStr());
        }

        return false;
    }

    public String getUrlStr() {
        return super.getUrl().toExternalForm();
    }

}

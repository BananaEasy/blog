package xyz.lihang.blog.mapper.model;

import java.util.Arrays;

/**
 * siteMap文件
 */
public class SiteMap {

    private String basePrefix;
    private String mainUrl;
    private String[] contains;

    public String getBasePrefix() {
        return basePrefix;
    }

    public void setBasePrefix(String basePrefix) {
        this.basePrefix = basePrefix;
    }

    public String getMainUrl() {
        return mainUrl;
    }

    public void setMainUrl(String mainUrl) {
        this.mainUrl = mainUrl;
    }

    public String[] getContains() {
        return contains;
    }

    public void setContains(String[] contains) {
        this.contains = contains;
    }

    @Override
    public String toString() {
        return "SiteMap{" +
                "basePrefix='" + basePrefix + '\'' +
                ", mainUrl='" + mainUrl + '\'' +
                ", contains=" + Arrays.toString(contains) +
                '}';
    }
}

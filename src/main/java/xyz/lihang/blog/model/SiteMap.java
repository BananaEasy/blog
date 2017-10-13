package xyz.lihang.blog.model;

import java.util.Arrays;

/**
 *
 */
public class SiteMap {

    private String dir;
    private String basePrefix;
    private String mainUrl;
    private String[] filter;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getBasePrefix() {
        return basePrefix;
    }

    public void setBasePrefix(String basePrefix) {
        this.basePrefix = basePrefix;
    }

    public String[] getFilter() {
        return filter;
    }

    public void setFilter(String[] filter) {
        this.filter = filter;
    }

    public String getMainUrl() {
        return mainUrl;
    }

    public void setMainUrl(String mainUrl) {
        this.mainUrl = mainUrl;
    }

    @Override
    public String toString() {
        return "SiteMap{" +
                "dir='" + dir + '\'' +
                ", basePrefix='" + basePrefix + '\'' +
                ", mainUrl='" + mainUrl + '\'' +
                ", filter=" + Arrays.toString(filter) +
                '}';
    }
}

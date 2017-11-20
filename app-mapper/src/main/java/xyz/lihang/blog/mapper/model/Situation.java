package xyz.lihang.blog.mapper.model;

/**
 * Created by LiHang on 2017/8/7.
 *
 * 统计访问情况
 */
public class Situation {
    //
    private Long articleCount;
    private Long messageCount;
    private Long accessCount;


    public Situation(Long articleCount, Long messageCount, Long accessCount) {
        this.articleCount = articleCount;
        this.messageCount = messageCount;
        this.accessCount = accessCount;
    }

    public Long getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Long articleCount) {
        this.articleCount = articleCount;
    }

    public Long getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(Long messageCount) {
        this.messageCount = messageCount;
    }

    public Long getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Long accessCount) {
        this.accessCount = accessCount;
    }



    @Override
    public String toString() {
        return "Situation{" +
                "articleCount=" + articleCount +
                ", messageCount=" + messageCount +
                ", accessCount=" + accessCount +
                '}';
    }
}

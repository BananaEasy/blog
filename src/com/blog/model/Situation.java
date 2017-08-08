package com.blog.model;

/**
 * Created by LiHang on 2017/8/7.
 *
 * 访问情况
 */
public class Situation {
    private Long articleCount;
    private Long messageCount;
    private Long accessCount;
    private Long commentCount;

    public Situation(Long articleCount, Long messageCount, Long accessCount, Long commentCount) {
        this.articleCount = articleCount;
        this.messageCount = messageCount;
        this.accessCount = accessCount;
        this.commentCount = commentCount;
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

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return "Situation{" +
                "articleCount=" + articleCount +
                ", messageCount=" + messageCount +
                ", accessCount=" + accessCount +
                ", commentCount=" + commentCount +
                '}';
    }
}

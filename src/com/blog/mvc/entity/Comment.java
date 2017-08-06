package com.blog.mvc.entity;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable{
    private String id;

    private Integer articleId;

    private String userId;

    private Date createtime;

    private Integer ismain;

    private Integer soncount;

    private String parentid;

    private Integer rank;

    private String temptitle;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getIsmain() {
        return ismain;
    }

    public void setIsmain(Integer ismain) {
        this.ismain = ismain;
    }

    public Integer getSoncount() {
        return soncount;
    }

    public void setSoncount(Integer soncount) {
        this.soncount = soncount;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getTemptitle() {
        return temptitle;
    }

    public void setTemptitle(String temptitle) {
        this.temptitle = temptitle == null ? null : temptitle.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "Comment [id=" + id + ", articleId=" + articleId + ", userId="
				+ userId + ", createtime=" + createtime + ", ismain=" + ismain
				+ ", soncount=" + soncount + ", parentid=" + parentid
				+ ", rank=" + rank + ", temptitle=" + temptitle + ", content="
				+ content + "]";
	}
    
    
}
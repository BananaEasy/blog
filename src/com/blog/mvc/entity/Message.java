package com.blog.mvc.entity;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private String id;

    private String userId;

    private Date createtime;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "Message [id=" + id + ", userId=" + userId + ", createtime="
				+ createtime + ", content=" + content + "]";
	}
    
    
}
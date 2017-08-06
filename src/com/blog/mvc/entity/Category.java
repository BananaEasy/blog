package com.blog.mvc.entity;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable{
    private Integer id;

    private Integer rank;

    private String link;

    private String name;

    private Integer parentid;

    private Date createtime;

    private Integer version;

    private String ico;

    private String record;

    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
    	
        this.parentid = parentid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico == null ? null : ico.trim();
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record == null ? null : record.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
    
	@Override
	public String toString() {
		return "Category [id=" + id + ", rank=" + rank + ", link=" + link
				+ ", name=" + name + ", parentid=" + parentid + ", createtime="
				+ createtime + ", version=" + version + ", ico=" + ico
				+ ", record=" + record + ", title=" + title + "]";
	}
    
    
    
}
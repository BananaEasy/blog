package com.blog.mvc.entity;

import java.io.Serializable;
import java.util.Date;

import com.blog.annotation.DataFinal;

public class Label implements Serializable{
	
	@DataFinal
    private Integer id;

    private String name;
    
    @DataFinal
    private Date createtime;
    
    @DataFinal
    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

	@Override
	public String toString() {
		return "Label [id=" + id + ", name=" + name + ", createtime="
				+ createtime + ", version=" + version + "]";
	}
    
    
}
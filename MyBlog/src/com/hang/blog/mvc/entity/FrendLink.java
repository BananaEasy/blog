package com.hang.blog.mvc.entity;

import java.io.Serializable;
import java.util.Date;

public class FrendLink  implements Serializable{
    private String id;

    private Date createtime;

    private Date endtime;

    private String link;

    private String linktitle;

    private Integer version;

    private String record;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getLinktitle() {
        return linktitle;
    }

    public void setLinktitle(String linktitle) {
        this.linktitle = linktitle == null ? null : linktitle.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record == null ? null : record.trim();
    }
}
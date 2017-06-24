package com.hang.blog.mvc.entity;

import java.io.Serializable;
import java.util.Date;

public class Article  implements Serializable{
    private Integer id;

    private Integer labelId;

    private Integer categoryId;

    private String articleusername;

    private Date createtime;

    private String articletitle;

    private String articlehref;

    private String articlehreftitle;

    private Long count;

    private Integer top;

    private Integer version;

    private Integer isoriginal;

    private String articletitleimagepath1;

    private String articletitleimagepath2;

    private String articlecontent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getArticleusername() {
        return articleusername;
    }

    public void setArticleusername(String articleusername) {
        this.articleusername = articleusername == null ? null : articleusername.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getArticletitle() {
        return articletitle;
    }

    public void setArticletitle(String articletitle) {
        this.articletitle = articletitle == null ? null : articletitle.trim();
    }

    public String getArticlehref() {
        return articlehref;
    }

    public void setArticlehref(String articlehref) {
        this.articlehref = articlehref == null ? null : articlehref.trim();
    }

    public String getArticlehreftitle() {
        return articlehreftitle;
    }

    public void setArticlehreftitle(String articlehreftitle) {
        this.articlehreftitle = articlehreftitle == null ? null : articlehreftitle.trim();
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getIsoriginal() {
        return isoriginal;
    }

    public void setIsoriginal(Integer isoriginal) {
        this.isoriginal = isoriginal;
    }

    public String getArticletitleimagepath1() {
        return articletitleimagepath1;
    }

    public void setArticletitleimagepath1(String articletitleimagepath1) {
        this.articletitleimagepath1 = articletitleimagepath1 == null ? null : articletitleimagepath1.trim();
    }

    public String getArticletitleimagepath2() {
        return articletitleimagepath2;
    }

    public void setArticletitleimagepath2(String articletitleimagepath2) {
        this.articletitleimagepath2 = articletitleimagepath2 == null ? null : articletitleimagepath2.trim();
    }

    public String getArticlecontent() {
        return articlecontent;
    }

    public void setArticlecontent(String articlecontent) {
        this.articlecontent = articlecontent == null ? null : articlecontent.trim();
    }
}
package xyz.lihang.blog.mapper.dto;

import java.util.Date;

public class ArticleDto {

    private Integer id;

    private String categoryName;

    private String articleusername;

    private Date createtime;

    private String articletitle;

    private String articletitleimagepath1;

    private String articleprompt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getArticleusername() {
        return articleusername;
    }

    public void setArticleusername(String articleusername) {
        this.articleusername = articleusername;
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
        this.articletitle = articletitle;
    }

    public String getArticletitleimagepath1() {
        return articletitleimagepath1;
    }

    public void setArticletitleimagepath1(String articletitleimagepath1) {
        this.articletitleimagepath1 = articletitleimagepath1;
    }

    public String getArticleprompt() {
        return articleprompt;
    }

    public void setArticleprompt(String articleprompt) {
        this.articleprompt = articleprompt;
    }
}

package xyz.lihang.blog.mvc.entity;

import xyz.lihang.blog.tool.utils.Page;
import java.util.List;

public class ArticleList {

    public ArticleList() {
    }

    public ArticleList(List<Article> list) {
        this.articleList = list;
        this.page = new Page<>(list);
    }

    List<Article> articleList;

    Page<Article> page;

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public Page<Article> getPage() {
        return page;
    }

    public void setPage(Page<Article> page) {
        this.page = page;
    }
}

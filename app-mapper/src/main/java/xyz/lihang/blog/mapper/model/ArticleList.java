package xyz.lihang.blog.mapper.model;

import xyz.lihang.blog.mapper.entity.Article;

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

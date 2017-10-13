package xyz.lihang.blog.mvc.service;

import xyz.lihang.blog.mvc.entity.Article;

public interface IArticleManagerService extends IBaseService<Article>{

	Article loadCategory(Article article);

	Article loadLabel(Article article);

	int  articleTop(Integer id);

	int articleSettingTopDefault(Integer id);
	
	
}

package com.blog.mvc.service;

import com.blog.mvc.entity.Article;

public interface IArticleManagerService extends IBaseService<Article>{

	Article loadCategory(Article article);

	Article loadLabel(Article article);

	int  articleTop(Integer id);

	int articleSettingTopDefault(Integer id);
	
	
}

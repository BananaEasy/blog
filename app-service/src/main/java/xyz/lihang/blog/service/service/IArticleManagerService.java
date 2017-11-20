package xyz.lihang.blog.service.service;

import org.springframework.cache.annotation.CacheEvict;
import xyz.lihang.blog.mapper.entity.Article;

public interface IArticleManagerService extends IBaseService<Article>{

	String ArticleListCacheName = "articleListCache";
	String ArticleBeanCacheName = "articleBeanCache";


	Article loadCategory(Article article);

	Article loadLabel(Article article);


	@CacheEvict(cacheNames= ArticleListCacheName, allEntries=true)
	int  articleTop(Integer id);

	@CacheEvict(cacheNames= ArticleListCacheName, allEntries=true)
	int articleSettingTopDefault(Integer id);

	@CacheEvict(cacheNames=ArticleBeanCacheName, allEntries=true)
	@Override
	int insert(Article article);

	@CacheEvict(cacheNames=ArticleBeanCacheName, allEntries=true)
	@Override
	int updateByPrimaryKey(Article article);
}

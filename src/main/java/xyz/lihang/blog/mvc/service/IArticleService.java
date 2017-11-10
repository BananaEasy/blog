package xyz.lihang.blog.mvc.service;

import org.springframework.cache.annotation.Cacheable;
import xyz.lihang.blog.model.ArticleMonths;
import xyz.lihang.blog.mvc.entity.Article;
import xyz.lihang.blog.mvc.entity.ArticleList;

import java.util.List;
import java.util.Map;

public interface IArticleService extends IArticleManagerService {

	@Cacheable(cacheNames = ArticleListCacheName,keyGenerator="cacheKeyGenerator")
	ArticleList  getIndexItem(Integer page);

	@Cacheable(cacheNames = ArticleListCacheName,keyGenerator="cacheKeyGenerator")
	ArticleList  getByCategoryItem(Integer categoryId,Integer page);

	@Cacheable(cacheNames = ArticleListCacheName,keyGenerator="cacheKeyGenerator")
	ArticleList  getByLabelItem(Integer labelId,Integer page);

	@Cacheable(cacheNames = ArticleListCacheName,keyGenerator="cacheKeyGenerator")
	ArticleList  getByDateItem( String DateStr,Integer page);

	@Cacheable(cacheNames = ArticleListCacheName,keyGenerator="cacheKeyGenerator")
	List<Article>  getSiteMapList();


	/**
	 * 下一个文章
	 * @param id
	 * @return
	 */
	Article getNextArticle(Integer id);


	/**
	 * 上一个文章
	 * @param id
	 * @return
	 */
	Article getPreArticle(Integer id);

	/**
	 * 显示文章
	 * pre 上一篇一篇文章
	 * index 当前文章
	 * next 下一篇文章
	 * @param id
	 * @return
	 */
	@Cacheable(cacheNames =ArticleBeanCacheName , keyGenerator="cacheKeyGenerator")
	Map<String,Article> show(Integer id);


	 /**
	  * 获取热门文章
	  * @return
	  */
	 List<Article>  getByHot();


	 /**
	  * 获取近期文章
	  * @return
	  */
	 List<Article>  getByLately();

	 /**
	  * 月份分组
	  * @return
	  */
	 List<ArticleMonths> groupByMonth();

}

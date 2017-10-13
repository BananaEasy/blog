package xyz.lihang.blog.mvc.service;

import java.util.List;
import java.util.Map;
import xyz.lihang.blog.model.ArticleMonths;
import xyz.lihang.blog.model.Condition;
import xyz.lihang.blog.mvc.entity.Article;

public interface IArticleService extends IArticleManagerService {
	//
	List<Article>  getIndexItem();
	
	
	List<Article>  getByCategoryItem(Integer categoryId);
	
	
	List<Article>  getByLabelItem(Integer labelId);
	
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
	 * 
	 * pre 上一篇一篇文章
	 * index 当前文章
	 * next 下一篇文章
	 * 
	 * @param id
	 * @return
	 */
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


	List<Article> getItem(Condition condition);
	
}

package com.blog.mvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.blog.model.ArticleMonths;
import com.blog.mvc.entity.Article;
import com.blog.mvc.entity.ArticleExample;
import com.blog.mvc.exception.NotFondException;
import com.blog.mvc.service.IArticleService;
import com.github.pagehelper.PageHelper;

@Service
public class ArticleService extends ArticleManagerService implements
		IArticleService {

	
	
	@Override
	public List<Article> getIndexItem() {
		ArticleExample articleExample = new ArticleExample();
		//只取未锁定的内容
		articleExample.createCriteria()
		.andIslockEqualTo(1);
		articleExample.setOrderByClause(defaultOrderBy);
		List<Article> list = articleMapper.selectItem(articleExample);
		for(int i=0;i<list.size();i++){
			loadCategory(list.get(i));
			loadLabel(list.get(i));
		}
		return list;
	}

	@Override
	public List<Article> getByCategoryItem(Integer categoryId) {
		ArticleExample articleExample = new ArticleExample();
		//只取未锁定的内容
		articleExample.createCriteria()
		.andIslockEqualTo(1)
		.andCategoryIdEqualTo(categoryId);
		articleExample.setOrderByClause(defaultOrderBy);
		return articleMapper.selectItem(articleExample);
	}

	@Override
	public List<Article> getByLabelItem(Integer labelId) {
		ArticleExample articleExample = new ArticleExample();
		//只取未锁定的内容
		articleExample.createCriteria()
		.andIslockEqualTo(1)
		.andLabelIdEqualTo(labelId);
		articleExample.setOrderByClause(defaultOrderBy);
		return articleMapper.selectItem(articleExample);
	}
	@Override
	public Map<String,Article> show(Integer id){
		Map<String,Article> ac = new HashMap<> ();
		Article article = articleMapper.selectByPrimaryKey(id);
		if(article == null || 1 != article.getIslock()){
			throw new NotFondException("文章ID : " + id);
		}
		loadCategory(article);
		loadLabel(article);
		ac.put("pre", getPreArticle(id));
		ac.put("index", article);
		ac.put("next", getNextArticle(id));
		return ac;
	}
	
	
	
	@Override
	public Article getNextArticle(Integer id) {
		return articleMapper.getNextArticle(id);
	}

	@Override
	public Article getPreArticle(Integer id) {
		return articleMapper.getPreArticle(id);
	}

	@Override
	public List<Article> getByHot() {
		PageHelper.startPage(1, 5);
		ArticleExample articleExample = new ArticleExample();
		//只取未锁定的内容
		articleExample.createCriteria()
		.andIslockEqualTo(1);
		String oderBy = "TOP_ DESC, COUNT_ DESC ";
		articleExample.setOrderByClause(oderBy);
		return articleMapper.selectTitle(articleExample);
	}

	@Override
	public List<Article> getByLately() {
		PageHelper.startPage(1, 5);
		ArticleExample articleExample = new ArticleExample();
		//只取未锁定的内容
		articleExample.createCriteria()
		.andIslockEqualTo(1);
		String oderBy = " CREATETIME DESC ";
		articleExample.setOrderByClause(oderBy);
		return articleMapper.selectTitle(articleExample);
	}
	@Override
	public List<ArticleMonths> groupByMonth(){
		return articleMapper.groupByMonth();
	}
}

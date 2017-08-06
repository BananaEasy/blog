package com.blog.mvc.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.mvc.dao.ArticleMapper;
import com.blog.mvc.dao.CategoryMapper;
import com.blog.mvc.dao.LabelMapper;
import com.blog.mvc.entity.Article;
import com.blog.mvc.entity.ArticleExample;
import com.blog.mvc.service.IArticleManagerService;
import com.blog.mvc.utils.BeanUpdateUtils;


@Service
public class ArticleManagerService extends BaseService<Article> implements
		IArticleManagerService {
	
	protected String defaultOrderBy ="TOP_ DESC,CREATETIME DESC" ;
	
	protected ArticleMapper articleMapper;
	@Resource
	protected CategoryMapper categoryMapper;
	@Resource
	protected LabelMapper labelMapper;
	
	@Resource
	public void setArticleMapper(ArticleMapper articleMapper) {
		this.articleMapper = articleMapper;
		super.setBaseMapper(articleMapper);
	}
	
	@Override
	public int insert(Article t) {
		t.setCreatetime(new Date());
		t.setVersion(0);
		t.setTop(0);
		return super.insert(t);
	}
	
	@Override
	public int updateByPrimaryKey(Article t) {
		Article temp = selectByPrimaryKey(t.getId());
		temp = (Article) BeanUpdateUtils.objClone(temp, t);
		temp.setVersion(temp.getVersion() + 1);
		return super.updateByPrimaryKey(temp);
	}
	
	
	
	@Override
	public List<Article> selectAll() {
		ArticleExample ae = new ArticleExample();
		ae.setOrderByClause(defaultOrderBy);
		List<Article> list= articleMapper.selectByExample(ae);
		for(int i=0;i<list.size();i++){
			loadCategory(list.get(i));
			loadLabel(list.get(i));
		}
		return list;
	}
	
	@Override
	public Article loadCategory (Article article){
		if(article != null && article.getCategoryId()!= null){
			article.setCategory(categoryMapper.selectByPrimaryKey(article.getCategoryId()));
		}
		return article;
	}
	
	@Override
	public Article loadLabel (Article article){
		if(article != null && article.getLabelId()!= null){
			article.setLable(labelMapper.selectByPrimaryKey(article.getLabelId()));
		}
		return article;
	}
	
	
	@Override
	public int articleTop(Integer id) {
		return articleMapper.articleTop(id);
	}
	
	
	@Override
	public int articleSettingTopDefault(Integer id) {
		Article a = selectByPrimaryKey(id);
		a.setTop(0);
		return updateByPrimaryKey(a);
	}
}

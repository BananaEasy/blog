package xyz.lihang.blog.mvc.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import xyz.lihang.blog.mvc.dao.ArticleMapper;
import xyz.lihang.blog.mvc.dao.CategoryMapper;
import xyz.lihang.blog.mvc.dao.LabelMapper;
import xyz.lihang.blog.mvc.entity.Article;
import xyz.lihang.blog.mvc.entityexample.ArticleExample;
import xyz.lihang.blog.mvc.service.IArticleManagerService;
import xyz.lihang.blog.tool.utils.BeanUpdateUtils;


@Service
public class ArticleManagerService extends BaseService<Article> implements
		IArticleManagerService {
	
	protected String defaultOrderBy ="TOP_ DESC,CREATETIME DESC" ;

	@Resource
	protected CategoryMapper categoryMapper;
	@Resource
	protected LabelMapper labelMapper;

	protected ArticleMapper articleMapper;

	
	@Resource
	public void setArticleMapper(ArticleMapper articleMapper) {
		this.articleMapper = articleMapper;
		super.setBaseMapper(articleMapper);
	}
	
	@Override
	@Transactional
	public int insert(Article article) {
		article.setCreatetime(new Date());
		article.setVersion(0);
		article.setTop(0);
		return super.insert(article);
	}
	
	@Override
	@Transactional
	public int updateByPrimaryKey(Article article) {
		Article temp = selectByPrimaryKey(article.getId());
		temp = (Article) BeanUpdateUtils.objClone(temp, article);
		temp.setVersion(temp.getVersion() + 1);
		return articleMapper.updateByPrimaryKeyWithBLOBs(temp);
	}
	

	@Override
	public List<Article> selectAll() {
		ArticleExample ae = new ArticleExample();
		ae.setOrderByClause(defaultOrderBy);
		List<Article> list= articleMapper.selectByExample(ae);
		return loadData(list);
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
			article.setLabel(labelMapper.selectByPrimaryKey(article.getLabelId()));
		}
		return article;
	}




	@Override
	@Transactional
	public int articleTop(Integer id) {
		return articleMapper.articleTop(id);
	}
	
	
	@Override
	public int articleSettingTopDefault(Integer id) {
		Article a = selectByPrimaryKey(id);
		a.setTop(0);
		a.setVersion(a.getVersion() + 1);
		return articleMapper.updateByPrimaryKeyWithBLOBs(a);
	}

	protected List<Article>  loadData(List<Article> list) {
		for(int i=0;i<list.size();i++){
			loadCategory(list.get(i));
			loadLabel(list.get(i));
		}
		return list;
	}

}

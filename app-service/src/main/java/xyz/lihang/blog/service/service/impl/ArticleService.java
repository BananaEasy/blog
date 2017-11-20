package xyz.lihang.blog.service.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import xyz.lihang.blog.common.tool.utils.DateUtil;
import xyz.lihang.blog.common.tool.utils.DateUtil2;
import xyz.lihang.blog.mapper.entity.Article;
import xyz.lihang.blog.mapper.example.ArticleExample;
import xyz.lihang.blog.mapper.model.ArticleList;
import xyz.lihang.blog.mapper.model.ArticleMonths;
import xyz.lihang.blog.service.config.ServiceConfig;
import xyz.lihang.blog.service.exception.NotFondException;
import xyz.lihang.blog.service.service.IArticleService;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleService extends ArticleManagerService implements
        IArticleService {

	@Override
	public ArticleList getIndexItem(Integer page) {
		ArticleExample articleExample = defaultSelectExample();
		PageHelper.startPage(page, ServiceConfig.ARTICLE_ITEM_LENGTH);
		List<Article> list = loadData(articleMapper.selectItem(articleExample));
		return new ArticleList(list);
	}

	@Override
	public ArticleList getByCategoryItem(Integer categoryId,Integer page) {
		ArticleExample articleExample =  defaultSelectExample();
		ArticleExample.Criteria criteria = articleExample.getOredCriteria().get(0);
		criteria.andCategoryIdEqualTo(categoryId);
		PageHelper.startPage(page, ServiceConfig.ARTICLE_ITEM_LENGTH);
		List<Article> list = loadData(articleMapper.selectItem(articleExample));
		return new ArticleList(list);
	}

	@Override
	public List<Article> getSiteMapList() {
		ArticleExample articleExample = defaultSelectExample();
		List<Article> list = loadData(articleMapper.selectItem(articleExample));
		return list;
	}

	@Override
	public ArticleList getByLabelItem(Integer labelId,Integer page) {
		ArticleExample articleExample = defaultSelectExample();
		ArticleExample.Criteria criteria = articleExample.getOredCriteria().get(0);
		criteria.andLabelIdEqualTo(labelId);
		PageHelper.startPage(page, ServiceConfig.ARTICLE_ITEM_LENGTH);
		List<Article> list = loadData(articleMapper.selectItem(articleExample));
		return new ArticleList(list);
	}

	@Override
	public ArticleList getByDateItem(String DateStr, Integer page) {
		ArticleExample articleExample = defaultSelectExample();
		ArticleExample.Criteria criteria = articleExample.getOredCriteria().get(0);
		if(DateUtil.isDate(DateStr) ){
			Date date = DateUtil.StringToDate(DateStr);
			Date startDate = DateUtil2.getFirstDayOfMonth(date);
			Date endDate = DateUtil2.getLastDayOfMonth(date);
			criteria.andCreatetimeBetween(startDate,endDate);
		}
		PageHelper.startPage(page, ServiceConfig.ARTICLE_ITEM_LENGTH);
		List<Article> list = loadData(articleMapper.selectItem(articleExample));
		return new ArticleList(list);
	}

	@Override
	public Map<String,Article> show(Integer id){
		Map<String,Article> ac = new HashMap<>();
		Article article = articleMapper.selectByPrimaryKey(id);
		if(article == null || Article.LOCK_FLAG != article.getIslock()){
			throw new NotFondException("文章不存在ID : " + id );
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
		ArticleExample articleExample = defaultSelectExample();
		String oderBy = "TOP_ DESC, COUNT_ DESC ";
		articleExample.setOrderByClause(oderBy);
		PageHelper.startPage(1, 5);
		return articleMapper.selectTitle(articleExample);
	}

	@Override
	public List<Article> getByLately() {
		ArticleExample articleExample =  defaultSelectExample();
		//只取未锁定的内容
		String oderBy = " CREATETIME DESC ";
		articleExample.setOrderByClause(oderBy);
		PageHelper.startPage(1, 5);
		return articleMapper.selectTitle(articleExample);
	}


	@Override
	public List<ArticleMonths> groupByMonth(){
		return articleMapper.groupByMonth();
	}


	protected ArticleExample defaultSelectExample (){
		ArticleExample articleExample = new ArticleExample();
		//只取未锁定的内容
		articleExample.createCriteria().andIslockEqualTo(Article.LOCK_FLAG);
		articleExample.setOrderByClause(defaultOrderBy);
		return  articleExample;
	}

}

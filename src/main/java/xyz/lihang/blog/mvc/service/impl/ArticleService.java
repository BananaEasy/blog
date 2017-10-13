package xyz.lihang.blog.mvc.service.impl;

import com.github.pagehelper.PageHelper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import xyz.lihang.blog.model.ArticleMonths;
import xyz.lihang.blog.model.Condition;
import xyz.lihang.blog.mvc.entity.Article;
import xyz.lihang.blog.mvc.entityexample.ArticleExample;
import xyz.lihang.blog.mvc.exception.NotFondException;
import xyz.lihang.blog.mvc.quartz.ArticleCountQuartz;
import xyz.lihang.blog.mvc.service.IArticleService;
import xyz.lihang.blog.tool.utils.DateUtil;
import xyz.lihang.blog.tool.utils.DateUtil2;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<String,Article> ac = new HashMap<>();
		Article article = articleMapper.selectByPrimaryKey(id);
		if(article == null || 1 != article.getIslock()){
			throw new NotFondException("文章ID : " + id);
		}
		//提交任务给定时器
		ArticleCountQuartz.addArticleId(id);

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


	@Override
	public List<Article> getItem(Condition condition) {
		if(condition == null){
			return getIndexItem();
		}

		ArticleExample articleExample = new ArticleExample();
		ArticleExample.Criteria criteria = articleExample.createCriteria();
		criteria.andIslockEqualTo(1);

		//类别
		if(	null != condition.getCid() ){
			criteria.andCategoryIdEqualTo(condition.getCid());
		}
		//标签
		if(	null != condition.getLid() ){
			criteria.andLabelIdEqualTo(condition.getLid());
		}
		//搜索
		if( StringUtils.isNotBlank( condition.getSearch() ) ){
			criteria.andArticletitleLike("%" + condition.getSearch() + "%");
		}
		//时间
		if(StringUtils.isNotBlank( condition.getDate())){
			try {
				if(DateUtil.isDate(condition.getDate()) ){
					Date date = DateUtil.StringToDate(condition.getDate());
					Date startDate = DateUtil2.getFirstDayOfMonth(date);
					Date endDate = DateUtil2.getLastDayOfMonth(date);
					criteria.andCreatetimeBetween(startDate,endDate);
				}

			}catch (Exception e){
				e.printStackTrace();
			}
		}

		articleExample.setOrderByClause(defaultOrderBy);
		List<Article> list = articleMapper.selectItem(articleExample);
		for(int i=0;i<list.size();i++){
			loadCategory(list.get(i));
			loadLabel(list.get(i));
		}
		return list;
	}
}

package xyz.lihang.blog.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.lihang.blog.mapper.entity.Article;
import xyz.lihang.blog.mapper.model.ArticleList;
import xyz.lihang.blog.quartz.quartz.ArticleCountQuartz;
import xyz.lihang.blog.quartz.quartz.ArticleLuceneQuartz;
import xyz.lihang.blog.service.config.ServiceConfig;
import xyz.lihang.blog.service.service.IArticleService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Controller
public class MainController extends BaseController{
	private final Logger log = LoggerFactory.getLogger(((getClass())));
	
	@Resource
	private IArticleService articleService;

	@Resource
	private ArticleLuceneQuartz articleLuceneQuartz;

	/**
	 * 主页
	 * @param model
	 * @param p
	 * @return
	 */
	@RequestMapping(value="/index" ,method={RequestMethod.GET})
	public String index(Model model,Integer p) {
		ArticleList articleList = articleService.getIndexItem(p == null? 1 : p);
		model.addAttribute("articleList", articleList.getArticleList());
		model.addAttribute("pageInfo", articleList.getPage());
		return "blog/articleList.ftl";
	}


	/**
	 * 搜索
	 * @param model
	 * @param searchStr
	 * @return
	 */
	@RequestMapping(value="/search")
	public String search(Model model,String searchStr,Integer p) {
		p = Math.max(p == null ? 1 : p,1);
		if(StringUtils.isNotBlank(searchStr)){
			Map<String, Object> map = articleLuceneQuartz.searchArticleTitleAfter(searchStr, p , ServiceConfig.ARTICLE_ITEM_LENGTH);
			model.addAttribute("searchStr",searchStr);
			model.addAttribute("pageNum",p);
			model.addAttribute("articleList", map.get("list"));
			model.addAttribute("total",map.get("total"));
		}
		return "blog/search.ftl";
	}


	/**
	 * 网站地图
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sitemap.html")
	public String siteMap(Model model) {
		List<Article> articleList = articleService.getSiteMapList();
		model.addAttribute("articleList", articleList);
		return "blog/sitemap.ftl";
	}


	/**
	 * 获取类别
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/category/{id}")
	public String getByCategory (Model model,@PathVariable("id") Integer id,Integer p) {
		ArticleList articleList = articleService.getByCategoryItem(id,p == null? 1 : p);
		model.addAttribute("articleList", articleList.getArticleList());
		model.addAttribute("pageInfo", articleList.getPage());
		return "blog/articleList.ftl";
	}

	/**
	 * 按月获取
	 * @param model
	 * @param dateStr
	 * @return
	 */
	@RequestMapping(value="/date/{dateStr}")
	public String getByDate (Model model,@PathVariable("dateStr") String dateStr,Integer p) {
		ArticleList articleList = articleService.getByDateItem(dateStr,p == null? 1 : p);
		model.addAttribute("articleList", articleList.getArticleList());
		model.addAttribute("pageInfo", articleList.getPage());
		return "blog/articleList.ftl";
	}

	/**
	 * 根据label id 获取
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/label/{id}")
	public String getByLabel (Model model,@PathVariable("id") Integer id,Integer p) {
		ArticleList articleList = articleService.getByLabelItem(id,p == null? 1 : p);
		model.addAttribute("articleList", articleList.getArticleList());
		model.addAttribute("pageInfo", articleList.getPage());
		return "blog/articleList.ftl";
	}

	/**
	 * 文章
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/article/{id}" ,method={RequestMethod.GET})
	public String article(Model model,@PathVariable("id") Integer id) {
		//提交任务给定时器
		ArticleCountQuartz.addArticleId(id);
		model.addAttribute("article", articleService.show(id));
		return "blog/article.ftl";
	}
}

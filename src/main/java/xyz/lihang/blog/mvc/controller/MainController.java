package xyz.lihang.blog.mvc.controller;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.lihang.blog.model.Condition;
import xyz.lihang.blog.mvc.Constant;
import xyz.lihang.blog.mvc.entity.Article;
import xyz.lihang.blog.mvc.service.IArticleService;
import xyz.lihang.blog.tool.utils.Page;
import javax.annotation.Resource;
import java.util.List;


@Controller
public class MainController extends BaseController{
	private final Logger log = LoggerFactory.getLogger(((getClass())));
	
	@Resource
	private IArticleService articleService;


	/**
	 * 主页
	 * @param model
	 * @param p
	 * @return
	 */
	@RequestMapping(value="/index" ,method={RequestMethod.GET})
	public String index(Model model,Integer p) {
		PageHelper.startPage(p == null? 1 : p, Constant.ARTICLE_ITEM_LENGTH);
		List<Article> indexItem = articleService.getIndexItem();
		model.addAttribute("articleList", indexItem);
		model.addAttribute("pageInfo", new Page<>(indexItem));
		return "blog/articleList.ftl";
	}


	/**
	 * 搜索
	 * @param model
	 * @param searchStr
	 * @return
	 */
	@RequestMapping(value="/search")
	public String search(Model model,String searchStr) {
		List<Article> indexItem = articleService.getItem(null);
		model.addAttribute("articleList", indexItem);
		return "blog/articleList.ftl";
	}


	/**
	 * 获取类别
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/category/{id}")
	public String getByCategory (Model model,@PathVariable("id") Integer id,Integer p) {
		PageHelper.startPage(p == null? 1 : p, Constant.ARTICLE_ITEM_LENGTH);
		List<Article> indexItem = articleService.getItem(new Condition().setCid(id));
		model.addAttribute("articleList", indexItem);
		model.addAttribute("pageInfo", new Page<>(indexItem));
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
		PageHelper.startPage(p == null? 1 : p, Constant.ARTICLE_ITEM_LENGTH);
		List<Article> indexItem = articleService.getItem(new Condition().setDate(dateStr));
		model.addAttribute("articleList", indexItem);
		model.addAttribute("pageInfo", new Page<>(indexItem));
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
		PageHelper.startPage(p == null? 1 : p, Constant.ARTICLE_ITEM_LENGTH);
		List<Article> indexItem = articleService.getItem(new Condition().setLid(id));
		model.addAttribute("articleList", indexItem);
		model.addAttribute("pageInfo", new Page<>(indexItem));
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
		model.addAttribute("article", articleService.show(id));
		return "blog/article.ftl";
	}

	


}

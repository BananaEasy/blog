package com.blog.mvc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.mvc.Constant;
import com.blog.mvc.cache.FreemakerCache;
import com.blog.mvc.entity.Article;
import com.blog.mvc.entity.Comment;
import com.blog.mvc.entity.User;
import com.blog.mvc.service.IArticleService;
import com.blog.mvc.service.ICommentService;
import com.blog.mvc.service.ISystemManagerService;
import com.blog.mvc.utils.Page;
import com.blog.mvc.utils.RenderJson;
import com.github.pagehelper.PageHelper;


@Controller
public class MainController extends BaseController{
	
	
	
	private final Log log = LogFactory.getLog(getClass());
	
	
	@Resource
	private ISystemManagerService systemManagerService;
	
	@Resource
	private IArticleService articleService;
	
	
	@Resource
	private FreemakerCache freemakerCache;
	
	@Resource
	private ICommentService commentService;
	
	
	/**
	 * 主页
	 * @param model
	 * @param p
	 * @return
	 */
	@RequestMapping(value="/index.action" ,method={RequestMethod.GET})
	public String index(Model model,Integer p) {
		PageHelper.startPage(p == null? 1 : p, Constant.ARTICLE_ITEM_LENGTH);
		List<Article> indexItem = articleService.getIndexItem();
		model.addAttribute("articleList", indexItem);
		model.addAttribute("pageInfo", new Page<Article>(indexItem));
		return "blog/articleList.ftl";
	}
	
	/**
	 * 留言板
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/message.action" ,method={RequestMethod.GET})
	public String message(Model model){
		return "blog/message.ftl";
	}
	
	/**
	 * 文章
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/article.action" ,method={RequestMethod.GET})
	public String article(Model model,Integer id) {
		model.addAttribute("article", articleService.show(id));
		return "blog/article.ftl";
	}
	
	
	
	
	/**
	 * 评论
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/comment.action" ,method={RequestMethod.GET})
	@ResponseBody
	public RenderJson comment(Model model,Comment comment,User user) {
		try{
			return commentService.comment(comment,user);
		}catch(Exception e){
			return RenderJson.Instance().ERROR().setMessage("请输入邮箱和用户名,方可评论");
		}
	}
	
	
	/**
	 * 获取评论
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getComment.action" ,method={RequestMethod.GET})
	@ResponseBody
	public RenderJson getComment(Model model,Integer id) {
		model.addAttribute("article", articleService.show(id));
		return RenderJson.Instance();
	}
	
	
}

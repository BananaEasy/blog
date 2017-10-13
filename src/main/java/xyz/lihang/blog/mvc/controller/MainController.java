package xyz.lihang.blog.mvc.controller;

import org.apache.commons.lang3.StringUtils;
import xyz.lihang.blog.annotation.RenderJsonInvok;
import xyz.lihang.blog.model.Condition;
import xyz.lihang.blog.model.LoginUser;
import xyz.lihang.blog.model.Message;
import xyz.lihang.blog.mvc.Constant;
import xyz.lihang.blog.mvc.entity.Article;
import xyz.lihang.blog.mvc.exception.MyException;
import xyz.lihang.blog.mvc.service.IArticleService;
import xyz.lihang.blog.tool.utils.Page;
import xyz.lihang.blog.tool.utils.RenderJson;
import xyz.lihang.blog.mvc.service.impl.MessageHandle;
import xyz.lihang.blog.tool.ToolWeb;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
public class MainController extends BaseController{
	
	
	
	private final Logger log = LoggerFactory.getLogger(((getClass())));
	

	@Resource
	private IArticleService articleService;
	@Resource
	private MessageHandle messageHandle;


	
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
		model.addAttribute("pageInfo", new Page<>(indexItem));
		return "blog/articleList.ftl";
	}

	/**
	 * 按条件显示
	 * @param model
	 * @param condition
	 * @return
	 */
	@RequestMapping(value="/item.action")
	public String item(Model model,Condition condition) {
		List<Article> indexItem = articleService.getItem(condition);
		model.addAttribute("articleList", indexItem);
		return "blog/articleList.ftl";
	}


	
	/**
	 * 留言板
	 * @return
	 */
	@RequestMapping(value="/message.action" ,method={RequestMethod.GET})
	public String message(){
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
	 * 登陆
	 */
	@RequestMapping(value="/loginAdmin.action" )
	public void login(HttpServletRequest request, HttpServletResponse response, String name, String password) throws IOException{
		if(!(StringUtils.isBlank(name) || StringUtils.isBlank(password))){
			LoginUser loginUser = new LoginUser(name,password);
			log.info("登陆User:" + loginUser);
			if(Constant.getUsers().contains(loginUser)){
				request.getSession().setAttribute("userLogin",loginUser);
			}
		}
		response.sendRedirect("/admin/index.action");
	}


	/**
	 * 留言
	 */
	@RenderJsonInvok
	@RequestMapping(value="/message/commont.action" )
	@ResponseBody
	public RenderJson messageCommont(HttpServletRequest request, Message message){
		RenderJson renderJson = RenderJson.Instance();
		if(message == null){
			throw new MyException("参数错误");
		}
		message.setIp(ToolWeb.getIpAddr(request));
		Message m = messageHandle.add(message);
		return renderJson.SUCCESS().setMessage("留言成功").setObj(m);
	}


	/**
	 * 留言列表
	 */
	@RenderJsonInvok(errorMsg = "获取失败")
	@RequestMapping(value="/message/commontList.action" )
	@ResponseBody
	public RenderJson messageCommontList(Integer p){
		RenderJson renderJson = RenderJson.Instance();
		if(p == null || p<= 0){
			p = 1;
		}
		List<Message> list = messageHandle.list(p,10);
		return renderJson.SUCCESS().setList(list);
	}

}

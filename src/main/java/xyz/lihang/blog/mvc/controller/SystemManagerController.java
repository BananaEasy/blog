package xyz.lihang.blog.mvc.controller;

import javax.annotation.Resource;

import xyz.lihang.blog.annotation.RenderJsonInvok;
import xyz.lihang.blog.mvc.quartz.FreemakerCache;
import xyz.lihang.blog.mvc.quartz.SEOQuartz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.lihang.blog.mvc.entity.Category;
import xyz.lihang.blog.mvc.service.ISystemManagerService;
import xyz.lihang.blog.tool.utils.EasyUIData;
import xyz.lihang.blog.tool.utils.RenderJson;


/**
 * 评论
 * @author LiHang
 *
 */
@RequestMapping(value="/admin/systemManager" )
@Controller
public class SystemManagerController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(SystemManagerController.class);




	@Resource
	private ISystemManagerService systemManagerService;

	@Resource
	private SEOQuartz seoQuartz;

	@Resource
	private FreemakerCache freemakerCache;

	@RequestMapping(value="/index.action" ,method={RequestMethod.GET})
	public String index(){
		return "systemManager/index.jsp";
	}
	
	@RequestMapping(value="/list.action")
	public @ResponseBody EasyUIData categoryList(){
		return new EasyUIData().setRows(systemManagerService.getList());
	}

	@RenderJsonInvok
	@RequestMapping(value="/add.action")
	@ResponseBody
	public  RenderJson add(Category category, Integer parentid){
		if(parentid!= null){
			category = category == null ? new Category(): category;
			category.setParentid(parentid);
		}
		systemManagerService.insert(category);
		return RenderJson.defaultSuccess();
	}
	@RenderJsonInvok
	@RequestMapping(value="/update.action")
	@ResponseBody
	public  RenderJson update(Category category){
		systemManagerService.updateByPrimaryKey(category);
		return RenderJson.defaultSuccess();
	}

	@RenderJsonInvok
	@RequestMapping(value="/delete.action")
	@ResponseBody
	public RenderJson delete(Integer id){
		systemManagerService.deleteByPrimaryKey(id);
		return RenderJson.defaultSuccess();
	}

	@RenderJsonInvok
	@RequestMapping(value="/refresh.action")
	@ResponseBody
	public RenderJson refresh(){
		freemakerCache.refresh();
		return RenderJson.defaultSuccess();
	}

	@RequestMapping(value="/sitemap.action")
	@ResponseBody
	public RenderJson sitemap(){
		seoQuartz.refreshSiteMap();
		return RenderJson.defaultSuccess();
	}



}

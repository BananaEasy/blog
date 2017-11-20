package xyz.lihang.blog.web.controller.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.lihang.blog.common.tool.annotation.RenderJsonInvok;
import xyz.lihang.blog.common.tool.utils.EasyUIData;
import xyz.lihang.blog.common.tool.utils.RenderJson;
import xyz.lihang.blog.mapper.entity.Category;
import xyz.lihang.blog.quartz.quartz.ArticleLuceneQuartz;
import xyz.lihang.blog.quartz.quartz.BlogCacheManager;
import xyz.lihang.blog.quartz.quartz.SEOQuartz;
import xyz.lihang.blog.service.service.ISystemManagerService;
import xyz.lihang.blog.web.controller.BaseController;

import javax.annotation.Resource;


/**
 * 评论
 * @author LiHang
 *
 */
@RequestMapping(value="/admin/systemManager" )
@Controller
public class SystemManagerController extends BaseController {
	
	private static final Logger log = LoggerFactory.getLogger(SystemManagerController.class);


	@Resource
	private ISystemManagerService systemManagerService;

	@Resource
	private SEOQuartz seoQuartz;

	@Resource
	private ArticleLuceneQuartz articleLuceneQuartz;

	@Resource
	private BlogCacheManager blogCacheManager;

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
	@RequestMapping(value="/refreshFreemakerCache.action")
	@ResponseBody
	public RenderJson refresh(){
		blogCacheManager.refreshFreemakerCache();
		articleLuceneQuartz.createIndex();
		return RenderJson.defaultSuccess();
	}

	@RequestMapping(value="/sitemap.action")
	@ResponseBody
	public RenderJson sitemap(){
		seoQuartz.refreshSiteMap();
		return RenderJson.defaultSuccess();
	}



}

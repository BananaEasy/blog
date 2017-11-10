package xyz.lihang.blog.mvc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import xyz.lihang.blog.annotation.RenderJsonInvok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.lihang.blog.model.Page;
import xyz.lihang.blog.mvc.entity.Article;
import xyz.lihang.blog.mvc.entity.Label;
import xyz.lihang.blog.mvc.service.IArticleManagerService;
import xyz.lihang.blog.mvc.service.ILabelService;
import xyz.lihang.blog.mvc.service.ISystemManagerService;
import xyz.lihang.blog.tool.utils.EasyUIData;
import xyz.lihang.blog.tool.utils.RenderJson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * 文章管理
 * @author LiHang
 *
 */
@RequestMapping(value="/admin/articleManager" )
@Controller
public class ArticleManagerController extends BaseController{
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource
	private IArticleManagerService articleManagerService;
	
	@Resource
	private ILabelService labelService;
	@Resource
	private ISystemManagerService systemManagerService;
	
	@RequestMapping(value="/index.action" ,method={RequestMethod.GET})
	public String index(Model model){
		return "articleManager/index.jsp";
	}
	
	
	@RequestMapping(value="/list.action" )
	@ResponseBody
	public EasyUIData list(Page page){
		PageHelper.startPage(page.getPage(), page.getRows());
		PageInfo<Article> p = new PageInfo<Article>(articleManagerService.selectAll());
		return new EasyUIData().setRows(p.getList()).setTotal(p.getTotal());
	}
	
	@RequestMapping(value="/articleSetting.action" )
	public String add(Model mm ,String flag,String id){
		if(StringUtils.isNotBlank(id) && flag.equals("update") ){
			mm.addAttribute("id", id);
			mm.addAttribute("flag", true);
		}
		mm.addAttribute("labelList",labelService.selectAll());
		mm.addAttribute("catgoryList",systemManagerService.selectAll());
		return "articleManager/addUI.jsp";
	}
	
	
	
	
	@RequestMapping(value="/get.action" )
	@ResponseBody
	public Article get (Integer id){
		try{
			return articleManagerService.selectByPrimaryKey(id);
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return null;
	}

	@RenderJsonInvok
	@RequestMapping(value="/add.action" )
	@ResponseBody
	public RenderJson add(Article article){
		articleManagerService.insert(article);
		return RenderJson.Instance().defaultSuccessMessage().SUCCESS() ;
	}

	@RenderJsonInvok
	@RequestMapping(value="/update.action" )
	@ResponseBody
	public RenderJson update(Article article){
		articleManagerService.updateByPrimaryKey(article);
		return RenderJson.Instance().defaultSuccessMessage().SUCCESS() ;
	}

	@RenderJsonInvok
	@RequestMapping(value="/delete.action" )
	@ResponseBody
	public RenderJson delete(Integer id){
		articleManagerService.deleteByPrimaryKey(id);
		return RenderJson.Instance().defaultSuccessMessage().SUCCESS() ;
	}

	@RenderJsonInvok
	@RequestMapping(value="/setTop.action" )
	@ResponseBody
	public RenderJson setTop(Integer id){
		articleManagerService.articleTop(id);
		return  RenderJson.Instance().defaultSuccessMessage().SUCCESS() ;
	}


	@RenderJsonInvok
	@RequestMapping(value="/setTopDefault.action" )
	@ResponseBody
	public RenderJson setTopDefault(Integer id){
		articleManagerService.articleSettingTopDefault(id);
		return RenderJson.Instance().defaultSuccessMessage().SUCCESS() ;
	}

	//Label管理
	
	@RequestMapping(value="/label/index.action" )
	public String index(Page page){
		return "articleManager/labelManager.jsp";
	}
	
	@RequestMapping(value="/label/list.action" )
	@ResponseBody
	public EasyUIData labelList(Page page){
		PageHelper.startPage(page.getPage(), page.getRows());
		List<Label> list = labelService.selectAll();
		PageInfo<Label> p = new PageInfo<Label>(list);
		return new EasyUIData().setRows(p.getList()).setTotal(p.getTotal());
	}

	@RenderJsonInvok
	@RequestMapping(value="/label/add.action" )
	@ResponseBody
	public RenderJson labelAdd(Label laabel){
		labelService.insert(laabel);
		return RenderJson.Instance().defaultSuccessMessage().SUCCESS() ;
	}

	@RenderJsonInvok
	@RequestMapping(value="/label/update.action" )
	@ResponseBody
	public RenderJson labelUpdate(Label laabel){
		labelService.updateByPrimaryKey(laabel);
		return  RenderJson.Instance().defaultSuccessMessage().SUCCESS() ;
	}

	@RenderJsonInvok
	@RequestMapping(value="/label/delete.action" )
	@ResponseBody
	public RenderJson labelDelete(Integer id){
		RenderJson instance = RenderJson.Instance();
		labelService.deleteByPrimaryKey(id);
		return instance.defaultSuccessMessage().SUCCESS() ;
	}
	
}

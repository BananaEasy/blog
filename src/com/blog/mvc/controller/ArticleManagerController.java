package com.blog.mvc.controller;

import java.util.List;

import javax.annotation.Resource;

import com.blog.annotation.RenderJsonInvok;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.model.Page;
import com.blog.mvc.entity.Article;
import com.blog.mvc.entity.Label;
import com.blog.mvc.service.IArticleManagerService;
import com.blog.mvc.service.ILabelService;
import com.blog.mvc.service.ISystemManagerService;
import com.blog.mvc.utils.EasyUIData;
import com.blog.mvc.utils.RenderJson;
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
	
	private Log log  = LogFactory.getLog(getClass());
	
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
	public String add(Model mm , String flag,String id){
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
		RenderJson instance = RenderJson.Instance();

		if( articleManagerService.insert(article) > 0 )
			return instance.defaultSuccessMessage().SUCCESS() ;

		return instance.defaultErrorMessage().ERROR() ;
	}

	@RenderJsonInvok
	@RequestMapping(value="/update.action" )
	@ResponseBody
	public RenderJson update(Article article){
		RenderJson instance = RenderJson.Instance();
		if( articleManagerService.updateByPrimaryKey(article) > 0 )
			return instance.defaultSuccessMessage().SUCCESS() ;

		return instance.defaultErrorMessage().ERROR() ;
	}

	@RenderJsonInvok
	@RequestMapping(value="/delete.action" )
	@ResponseBody
	public RenderJson delete(Integer id){

		if( articleManagerService.deleteByPrimaryKey(id) > 0 ){
			return RenderJson.Instance().defaultSuccessMessage().SUCCESS() ;
		}
		return RenderJson.Instance().defaultErrorMessage().ERROR() ;
	}

	@RenderJsonInvok
	@RequestMapping(value="/setTop.action" )
	@ResponseBody
	public RenderJson setTop(Integer id){
		RenderJson instance = RenderJson.Instance();
		if( articleManagerService.articleTop(id) > 0 ){
			return instance.defaultSuccessMessage().SUCCESS() ;
		}
		return instance.defaultErrorMessage().ERROR() ;
	}


	@RenderJsonInvok
	@RequestMapping(value="/setTopDefault.action" )
	@ResponseBody
	public RenderJson setTopDefault(Integer id){
		if( articleManagerService.articleSettingTopDefault(id) > 0 ){
			return RenderJson.Instance().defaultSuccessMessage().SUCCESS() ;
		}
		return RenderJson.Instance().defaultErrorMessage().ERROR() ;
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
		RenderJson instance = RenderJson.Instance();
		if( labelService.insert(laabel) > 0 ){
			return instance.defaultSuccessMessage().SUCCESS() ;
		}
		return instance.defaultErrorMessage().ERROR() ;
	}

	@RenderJsonInvok
	@RequestMapping(value="/label/update.action" )
	@ResponseBody
	public RenderJson labelUpdate(Label laabel){
		RenderJson instance = RenderJson.Instance();
		if( labelService.updateByPrimaryKey(laabel) > 0 ){
			return instance.defaultSuccessMessage().SUCCESS() ;
		}
		return instance.defaultErrorMessage().ERROR() ;
	}

	@RenderJsonInvok
	@RequestMapping(value="/label/delete.action" )
	@ResponseBody
	public RenderJson labelDelete(Integer id){
		RenderJson instance = RenderJson.Instance();
		if( labelService.deleteByPrimaryKey(id) > 0 ){
			return instance.defaultSuccessMessage().SUCCESS() ;
		}
		return instance.defaultErrorMessage().ERROR() ;
	}
	
}

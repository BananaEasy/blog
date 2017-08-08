package com.blog.mvc.controller;

import javax.annotation.Resource;

import com.blog.mvc.cache.FreemakerCache;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.mvc.entity.Category;
import com.blog.mvc.service.ISystemManagerService;
import com.blog.mvc.utils.EasyUIData;
import com.blog.mvc.utils.RenderJson;


/**
 * 评论
 * @author LiHang
 *
 */
@RequestMapping(value="/admin/systemManager" )
@Controller
public class SystemManagerController extends BaseController{
	
	private static final Log log = LogFactory.getLog(SystemManagerController.class);




	@Resource
	private ISystemManagerService systemManagerService;

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
	
	@RequestMapping(value="/add.action")
	public @ResponseBody RenderJson add(Category category, Integer parentid){
		try{
			if(parentid!= null){
				category = category == null ? new Category(): category;
				category.setParentid(parentid);
			}
			int successCount = systemManagerService.insert(category);
			if(successCount > 0 ){
				return RenderJson.Instance().SUCCESS().defaultSuccessMessage();
			}
		}catch(Exception e){
			log.info(e.getMessage());
		}
		return RenderJson.Instance().ERROR().defaultErrorMessage();
	}
	
	@RequestMapping(value="/update.action")
	public @ResponseBody RenderJson update(Category category){
		try{
			int successCount = systemManagerService.updateByPrimaryKey(category);
			if(successCount > 0 ){
				return RenderJson.Instance().SUCCESS().defaultSuccessMessage();
			}
		}catch(Exception e){
			log.info(e.getMessage());
		}
		return RenderJson.Instance().ERROR().defaultErrorMessage();
	}
	
	@RequestMapping(value="/delete.action")
	public @ResponseBody RenderJson delete(Integer id){
		try{
			int successCount = systemManagerService.deleteByPrimaryKey(id);
			if(successCount > 0 ){
				return RenderJson.Instance().SUCCESS().defaultSuccessMessage();
			}
		}catch(Exception e){
			log.info(e.getMessage());
		}
		return RenderJson.Instance().ERROR().defaultErrorMessage();
	}

	@RequestMapping(value="/refresh.action")
	public @ResponseBody RenderJson refresh(Integer id){
		try{
			freemakerCache.refresh();
			return RenderJson.Instance().SUCCESS().defaultSuccessMessage();
		}catch(Exception e){
			log.info(e.getMessage());
		}
		return RenderJson.Instance().ERROR().defaultErrorMessage();
	}




}

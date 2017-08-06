package com.blog.mvc.controller;

import com.blog.model.Page;
import com.blog.mvc.entity.FrendLink;
import com.blog.mvc.service.IFrendLinkService;
import com.blog.mvc.utils.EasyUIData;
import com.blog.mvc.utils.RenderJson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;


/**
 * 友情链接
 * @author LiHang
 *
 */
@RequestMapping(value="/admin/frendLinkManager" )
@Controller
public class FrendLinkManagerController extends BaseController{

	@Resource
	private IFrendLinkService frendLinkService;


	@RequestMapping(value="/index.action")
	public String index(Model model){
		return "frendLink/index.jsp";
	}

	@RequestMapping(value="/list.action" )
	@ResponseBody
	public EasyUIData list(Page page){
		PageHelper.startPage(page.getPage(), page.getRows());
		PageInfo<FrendLink> p = new PageInfo<FrendLink>(frendLinkService.selectAll());
		return new EasyUIData().setRows(p.getList()).setTotal(p.getTotal());
	}

	@RequestMapping(value="/add.action" )
	@ResponseBody
	public RenderJson add(FrendLink frendLink){
		RenderJson renderJson = RenderJson.Instance().defaultErrorMessage().ERROR();
		try{
			int insert = frendLinkService.insert(frendLink);
			if(insert > 0){
				renderJson.SUCCESS().defaultSuccessMessage();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return renderJson;
	}

	@RequestMapping(value="/delete.action" )
	@ResponseBody
	public RenderJson delete(String id){
		RenderJson renderJson = RenderJson.Instance().defaultErrorMessage().ERROR();
		try{
			int insert = frendLinkService.deleteByPrimaryKey(id);
			if(insert > 0){
				renderJson.SUCCESS().defaultSuccessMessage();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return renderJson;
	}

	@RequestMapping(value="/update.action")
	@ResponseBody
	public RenderJson update(FrendLink frendLink){
		RenderJson renderJson = RenderJson.Instance().defaultErrorMessage().ERROR();
		try{
			int insert = frendLinkService.updateByPrimaryKey(frendLink);
			if(insert > 0){
				renderJson.SUCCESS().defaultSuccessMessage();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return renderJson;
	}

}

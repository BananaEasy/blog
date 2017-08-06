package com.blog.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 留言管理
 * @author LiHang
 *
 */
@RequestMapping(value="/admin/massageManager" )
@Controller
public class MassageManagerController extends BaseController{
	@RequestMapping(value="/index.action" ,method={RequestMethod.GET})
	public String index(Model model){
		return "manager/manager.jsp";
	}
	
}

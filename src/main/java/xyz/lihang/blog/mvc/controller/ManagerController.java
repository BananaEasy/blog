package xyz.lihang.blog.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/admin" )
@Controller
public class ManagerController extends BaseController{
	@RequestMapping(value="/index.action" ,method={RequestMethod.GET})
	public String index(Model model){
		return "manager/manager.jsp";
	}
}

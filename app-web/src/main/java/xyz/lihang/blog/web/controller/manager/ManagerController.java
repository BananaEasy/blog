package xyz.lihang.blog.web.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.lihang.blog.web.controller.BaseController;

@RequestMapping(value="/admin" )
@Controller
public class ManagerController extends BaseController {
	@RequestMapping(value="/index.action" ,method={RequestMethod.GET})
	public String index(){
		return "manager/manager.jsp";
	}
}

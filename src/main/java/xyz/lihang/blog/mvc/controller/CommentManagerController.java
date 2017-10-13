package xyz.lihang.blog.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 评论
 * @author LiHang
 *
 */
@RequestMapping(value="/admin/commentManager" )
@Controller
public class CommentManagerController extends BaseController{
	@RequestMapping(value="/index.action")
	public String index(){
		return "manager/manager.jsp";
	}
}

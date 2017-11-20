package xyz.lihang.blog.web.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.lihang.blog.web.controller.BaseController;


/**
 * 评论
 * @author LiHang
 *
 */
@RequestMapping(value="/admin/commentManager" )
@Controller
public class CommentManagerController extends BaseController {
	@RequestMapping(value="/index.action")
	public String index(){
		return "manager/manager.jsp";
	}
}

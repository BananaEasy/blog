package com.blog.mvc.controller;

import com.blog.model.Message;
import com.blog.model.Page;
import com.blog.mvc.utils.EasyUIData;
import com.blog.mvc.utils.RenderJson;
import com.blog.redis.mvc.service.MessageHandle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


/**
 * 留言管理
 * @author LiHang
 *
 */
@RequestMapping(value="/admin/massageManager" )
@Controller
public class MassageManagerController extends BaseController{

	@Resource
	private MessageHandle messageHandle;

	@RequestMapping(value="/index.action" ,method={RequestMethod.GET})
	public String index(Model model){
		return "message/index.jsp";
	}

	@RequestMapping(value="/list.action")
	@ResponseBody
	public EasyUIData list (Page page){
		List<Message> list = messageHandle.list(page.getPage(), page.getRows());
		return  new EasyUIData().setRows(list).setTotal(messageHandle.getCount());
	}

	@RequestMapping(value="/delete.action")
	@ResponseBody
	public RenderJson delete (){
		messageHandle.leftPop();
		return RenderJson.Instance().SUCCESS().defaultSuccessMessage();
	}

	
}

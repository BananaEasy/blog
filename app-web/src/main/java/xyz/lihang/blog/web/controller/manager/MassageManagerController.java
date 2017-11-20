package xyz.lihang.blog.web.controller.manager;

import xyz.lihang.blog.common.tool.annotation.RenderJsonInvok;
import xyz.lihang.blog.mapper.model.Message;
import xyz.lihang.blog.common.tool.easyui.Page;
import xyz.lihang.blog.common.tool.utils.EasyUIData;
import xyz.lihang.blog.common.tool.utils.RenderJson;
import xyz.lihang.blog.service.redis.MessageHandle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.lihang.blog.web.controller.BaseController;

import javax.annotation.Resource;
import java.util.List;


/**
 * 留言管理
 * @author LiHang
 *
 */
@RequestMapping(value="/admin/massageManager" )
@Controller
public class MassageManagerController extends BaseController {

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

	@RenderJsonInvok
	@RequestMapping(value="/delete.action")
	@ResponseBody
	public RenderJson delete (){
		messageHandle.leftPop();
		return RenderJson.defaultSuccess();
	}

	
}

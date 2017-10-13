package xyz.lihang.blog.mvc.controller;

import xyz.lihang.blog.annotation.RenderJsonInvok;
import xyz.lihang.blog.model.Page;
import xyz.lihang.blog.mvc.entity.FrendLink;
import xyz.lihang.blog.mvc.service.IFrendLinkService;
import xyz.lihang.blog.tool.utils.EasyUIData;
import xyz.lihang.blog.tool.utils.RenderJson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RenderJsonInvok
	@RequestMapping(value="/add.action" )
	@ResponseBody
	public RenderJson add(FrendLink frendLink){
		frendLinkService.insert(frendLink);
		return RenderJson.defaultSuccess();
	}

	@RenderJsonInvok
	@RequestMapping(value="/delete.action" )
	@ResponseBody
	public RenderJson delete(String id){
		frendLinkService.deleteByPrimaryKey(id);
		return RenderJson.defaultSuccess();
	}

	@RenderJsonInvok
	@RequestMapping(value="/update.action")
	@ResponseBody
	public RenderJson update(FrendLink frendLink){
		frendLinkService.updateByPrimaryKey(frendLink);
		return RenderJson.defaultSuccess();
	}

}

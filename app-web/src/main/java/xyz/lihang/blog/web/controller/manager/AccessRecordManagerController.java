package xyz.lihang.blog.web.controller.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.lihang.blog.common.tool.utils.EasyUIData;
import xyz.lihang.blog.common.tool.easyui.Page;
import xyz.lihang.blog.mapper.dao.AccessRecordMapper;
import xyz.lihang.blog.mapper.entity.AccessRecord;
import xyz.lihang.blog.mapper.example.AccessRecordExample;
import xyz.lihang.blog.web.controller.BaseController;

import javax.annotation.Resource;
import java.util.List;


/**
 * 访问日志
 * @author LiHang
 *
 */
@RequestMapping(value="/admin/accessRecordManager" )
@Controller
public class AccessRecordManagerController extends BaseController {

	@Resource
	private AccessRecordMapper accessRecordMapper;

	@RequestMapping(value="/index.action" )
	public String index(){
		return "accessRecord/index.jsp";
	}


	@RequestMapping(value="/list.action" )
	@ResponseBody
	public EasyUIData list(Page page){

		AccessRecordExample accessRecordExample = new AccessRecordExample();

		accessRecordExample.setOrderByClause(" STARTTIME_ DESC ");

		PageHelper.startPage(page.getPage(), page.getRows());

		List<AccessRecord> accessRecords = accessRecordMapper.selectByExample( accessRecordExample );

		PageInfo<AccessRecord> p = new PageInfo<>( accessRecords );

		return new EasyUIData().setRows(p.getList()).setTotal(p.getTotal());
	}

}

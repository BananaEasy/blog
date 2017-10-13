package xyz.lihang.blog.mvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.lihang.blog.model.Page;
import xyz.lihang.blog.mvc.dao.AccessRecordMapper;
import xyz.lihang.blog.mvc.entity.AccessRecord;
import xyz.lihang.blog.mvc.entityexample.AccessRecordExample;
import xyz.lihang.blog.tool.utils.EasyUIData;

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

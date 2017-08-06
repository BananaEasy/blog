package com.blog.mvc.controller;

import com.blog.model.Page;
import com.blog.mvc.dao.AccessRecordMapper;
import com.blog.mvc.entity.AccessRecord;
import com.blog.mvc.utils.EasyUIData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;


/**
 * 评论
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
		PageHelper.startPage(page.getPage(), page.getRows());
		PageInfo<AccessRecord> p = new PageInfo<>(accessRecordMapper.selectByExample());
		return new EasyUIData().setRows(p.getList()).setTotal(p.getTotal());
	}

}

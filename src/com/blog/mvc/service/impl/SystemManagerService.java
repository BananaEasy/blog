package com.blog.mvc.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.model.MenuModel;
import com.blog.model.MenuModelFactory;
import com.blog.mvc.dao.CategoryMapper;
import com.blog.mvc.entity.Category;
import com.blog.mvc.entity.CategoryExample;
import com.blog.mvc.service.ISystemManagerService;

@Service
public class SystemManagerService extends BaseService<Category> implements ISystemManagerService{
	
	private CategoryMapper categoryMapper;
	
	@Resource
	public void setCategoryMapper(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
		super.setBaseMapper(categoryMapper);
	}
	
	@Override
	public List<Category> getList (){
		CategoryExample categoryExample = new CategoryExample();
		categoryExample.setOrderByClause("PARENTID_  ASC, ID ASC");
		return categoryMapper.selectByExample(categoryExample);
	}
	
	
	@Override
	public int insert(Category t) {
		if(t == null)
			t= new Category();
		t.setVersion(0);
		t.setLink("javasctipt:;");
		t.setCreatetime(new Date());
		return super.insert(t);
	}
	
	@Override
	public int updateByPrimaryKey(Category t) {
		Category c = super.selectByPrimaryKey(t.getId());
		t.setCreatetime(c.getCreatetime());
		t.setVersion(c.getVersion() + 1);
		return super.updateByPrimaryKey(t);
	}

	@Override
	public List<MenuModel> getMenuList() {
		return MenuModelFactory.parseCategoryList(getList());
	}
	
	
}

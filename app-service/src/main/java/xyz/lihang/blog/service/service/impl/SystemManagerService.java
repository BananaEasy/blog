package xyz.lihang.blog.service.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.lihang.blog.mapper.dao.CategoryMapper;
import xyz.lihang.blog.mapper.entity.Category;
import xyz.lihang.blog.mapper.example.CategoryExample;
import xyz.lihang.blog.mapper.model.MenuModel;
import xyz.lihang.blog.mapper.model.MenuModelFactory;
import xyz.lihang.blog.service.service.ISystemManagerService;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SystemManagerService extends BaseService<Category> implements ISystemManagerService {
	
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
	@Transactional
	public int insert(Category t) {
		if(t == null)
			t= new Category();
		t.setVersion(0);
		t.setLink("javasctipt:;");
		t.setCreatetime(new Date());
		return super.insert(t);
	}
	
	@Override
	@Transactional
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

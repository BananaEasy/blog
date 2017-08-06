package com.blog.mvc.service;

import java.util.List;

import com.blog.model.MenuModel;
import com.blog.mvc.entity.Category;

public interface ISystemManagerService extends IBaseService<Category> {

	List<Category> getList();

	List<MenuModel> getMenuList();
	
	
}

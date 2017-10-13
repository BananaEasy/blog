package xyz.lihang.blog.mvc.service;

import java.util.List;

import xyz.lihang.blog.model.MenuModel;
import xyz.lihang.blog.mvc.entity.Category;

public interface ISystemManagerService extends IBaseService<Category> {

	List<Category> getList();

	List<MenuModel> getMenuList();
	
	
}

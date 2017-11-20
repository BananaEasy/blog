package xyz.lihang.blog.service.service;

import xyz.lihang.blog.mapper.entity.Category;
import xyz.lihang.blog.mapper.model.MenuModel;

import java.util.List;

public interface ISystemManagerService extends IBaseService<Category> {

	List<Category> getList();

	List<MenuModel> getMenuList();
	
	
}

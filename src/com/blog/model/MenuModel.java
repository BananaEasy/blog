package com.blog.model;

import java.util.ArrayList;
import java.util.List;

import com.blog.mvc.entity.Category;


/**
 * 
 * 菜单栏构建Model
 * 
 * @author LiHang
 *
 */
public class MenuModel {
	
	/**
	 *  我的类别 
	 */
	private Category thisCategory;
	
	/**
	 * 子菜单列表
	 */
	private List<Category> sonCategoryList;
	/**
	 * 是否还有子菜单
	 */
	private boolean isSon ;
	
	
	
	public MenuModel() {
		
	}
	
	
	public MenuModel(Category category ,List<Category> sonCategoryList) {
		this.thisCategory = category;
		init();
	}
	/**
	 * 构建
	 * @return
	 */
	public MenuModel init(){
		this.isSon = !(sonCategoryList == null || sonCategoryList.size() == 0);
		return this;
	}
	/**
	 * 添加子类别
	 * @return
	 */
	public MenuModel addSonCategory (Category category){
		this.sonCategoryList = this.sonCategoryList==null ? new ArrayList<>(5) :  this.sonCategoryList;
		sonCategoryList.add(category);
		return init();
	}
	

	public Category getThisCategory() {
		return thisCategory;
	}
	public MenuModel setThisCategory(Category thisCategory) {
		this.thisCategory = thisCategory;
		return this;
	}

	public List<Category> getSonCategoryList() {
		return sonCategoryList;
	}

	public MenuModel setSonCategoryList(List<Category> sonCategoryList) {
		this.sonCategoryList = sonCategoryList;
		return init();
	}

	public boolean getIsSon() {
		return isSon;
	}

	public MenuModel setSon(boolean isSon) {
		this.isSon = isSon;
		return this;
	}
	
}

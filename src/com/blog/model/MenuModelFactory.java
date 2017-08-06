package com.blog.model;

import java.util.ArrayList;
import java.util.List;

import com.blog.mvc.entity.Category;

public class MenuModelFactory {
	
	/**
	 * 获取一个模型
	 * @return
	 */
	public static MenuModel getMenuModel (){
		return new MenuModel().init();
	}
	
	
	/**
	 * 将类别列表转换成菜单列表
	 * @param categoryList
	 * @return
	 */
	public static List<MenuModel> parseCategoryList (List<Category> categoryList){
		List<MenuModel> menuList = new ArrayList<>(0);
		return parseCategoryListMehod(categoryList,menuList,0);
	}
	
	
	/**
	 * 构造树形结构递归方法
	 * @param categoryList
	 * @param menuList
	 * @param index
	 * @return
	 */
	private static List<MenuModel> parseCategoryListMehod (List<Category> categoryList,List<MenuModel> menuList,int index){
		if(index == categoryList.size()){
			return menuList;
		}
		Category c = categoryList.get(index);
		
		
		if(c.getParentid() == null){
			//将父节点添加进去
			menuList.add(getMenuModel().setThisCategory(c));
		}else{
			//添加成功的标记
			boolean addFlag =  false;
			for(int i=0;i<menuList.size();i++){
				MenuModel fatherCategory = menuList.get(i);
				//判断我的fuid　＝＝　fu Id
				if(c.getParentid().equals(fatherCategory.getThisCategory().getId())){
					fatherCategory.addSonCategory(c);
					addFlag = true;
					break;
				}
			}
			if(!addFlag){
				menuList.add(getMenuModel().setThisCategory(c));
			}
			
		}
		return parseCategoryListMehod (categoryList, menuList,++index);
	}
	
}

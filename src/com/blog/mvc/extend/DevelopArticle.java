package com.blog.mvc.extend;

import com.blog.mvc.entity.Category;
import com.blog.mvc.entity.Label;


/**
 * 扩展Article 对象   使其可以设置关联数据
 * @author LiHang
 *
 */
public class DevelopArticle {
	
	
	private Label lable;
	
	
	private Category category;
	
	
	public Label getLable() {
		return lable;
	}
	public void setLable(Label lable) {
		this.lable = lable;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}

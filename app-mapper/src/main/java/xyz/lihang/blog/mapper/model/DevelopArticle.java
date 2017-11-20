package xyz.lihang.blog.mapper.model;

import xyz.lihang.blog.mapper.entity.Label;
import xyz.lihang.blog.mapper.entity.Category;


/**
 * 扩展Article 对象   使其可以设置关联数据
 * @author LiHang
 *
 */
public class DevelopArticle {
	
	
	private Label label;
	
	
	private Category category;


	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}

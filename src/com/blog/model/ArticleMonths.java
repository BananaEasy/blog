package com.blog.model;

public class ArticleMonths {
	private String months;
	private Long count;
	
	
	public String getMonths() {
		return months;
	}
	public void setMonths(String months) {
		this.months = months;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ArticleMonths [months=" + months + ", count=" + count + "]";
	}
	
}

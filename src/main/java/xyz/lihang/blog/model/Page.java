package xyz.lihang.blog.model;

public class Page {
	private Integer rows;
	private Integer page;
	
	
	public Integer getRows() {
		return rows==null ? 0 : rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getPage() {
		return page == null ? 0 : page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	
}

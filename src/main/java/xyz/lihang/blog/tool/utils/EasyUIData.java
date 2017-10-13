package xyz.lihang.blog.tool.utils;

import java.util.List;

public class EasyUIData {
	
	private Long total;
	
	private List rows;

	public Long getTotal() {
		return total;
	}

	public EasyUIData setTotal(Long total) {
		this.total = total;
		return this;
	}

	public List getRows() {
		return rows;
	}

	public EasyUIData setRows(List<?> rows) {
		this.rows = rows;
		return this;
	}
	
	
	
	
}

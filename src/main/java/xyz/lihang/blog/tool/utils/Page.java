package xyz.lihang.blog.tool.utils;

import java.util.List;

import com.github.pagehelper.PageInfo;


/**
 * 分页
 * @author LiHang
 *
 * @param <T>
 */


public class Page<T> {
	
	private Integer pageNum;
	private Integer pageSize;
	private Integer size;
	private Integer startRow;
	private Integer endRow;
	private Long total;
	private Integer pages;
	
	private Integer prePage;
	private Integer nextPage;
	private boolean isFirstPage;
	private boolean isLastPage;
	private boolean hasPreviousPage;
	private boolean hasNextPage;
	private Integer navigatePages;
	private int [] navigatepageNums;
	private Integer navigateFirstPage;
	private Integer navigateLastPage;
	
	public Page() {
	}
	
	
	public Page(List<T> list) {
		PageInfo<T> pageInfo = new PageInfo<T> (list);
		
		pageNum = pageInfo.getPageNum();
		pageSize = pageInfo.getPageSize();
		size = pageInfo.getSize();
		startRow = pageInfo.getStartRow();
		endRow = pageInfo.getEndRow();
		total = pageInfo.getTotal();
		pages = pageInfo.getPages();
		
		
		
		prePage = pageInfo.getPrePage();
		nextPage= pageInfo.getNextPage();
		isFirstPage = pageInfo.isIsFirstPage();
		isLastPage= pageInfo.isIsLastPage();
		hasPreviousPage= pageInfo.isHasPreviousPage();
		hasNextPage= pageInfo.isHasNextPage();
		navigatePages= pageInfo.getNavigatePages();
		navigatepageNums= pageInfo.getNavigatepageNums();
		navigateFirstPage= pageInfo.getNavigateFirstPage();
		navigateLastPage= pageInfo.getNavigateLastPage();
	}


	public Integer getPageNum() {
		return pageNum;
	}


	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public Integer getSize() {
		return size;
	}


	public void setSize(Integer size) {
		this.size = size;
	}


	public Integer getStartRow() {
		return startRow;
	}


	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}


	public Integer getEndRow() {
		return endRow;
	}


	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}


	public Long getTotal() {
		return total;
	}


	public void setTotal(Long total) {
		this.total = total;
	}


	public Integer getPages() {
		return pages;
	}


	public void setPages(Integer pages) {
		this.pages = pages;
	}


	public Integer getPrePage() {
		return prePage;
	}


	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}


	public Integer getNextPage() {
		return nextPage;
	}


	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}


	public boolean isIsFirstPage() {
		return isFirstPage;
	}


	public void setIsFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}


	public boolean isIsLastPage() {
		return isLastPage;
	}


	public void setIsLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}


	public boolean getHasPreviousPage() {
		return hasPreviousPage;
	}


	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}


	public boolean getHasNextPage() {
		return hasNextPage;
	}


	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}


	public Integer getNavigatePages() {
		return navigatePages;
	}


	public void setNavigatePages(Integer navigatePages) {
		this.navigatePages = navigatePages;
	}


	public int[] getNavigatepageNums() {
		return navigatepageNums;
	}


	public void setNavigatepageNums(int[] navigatepageNums) {
		this.navigatepageNums = navigatepageNums;
	}


	public Integer getNavigateFirstPage() {
		return navigateFirstPage;
	}


	public void setNavigateFirstPage(Integer navigateFirstPage) {
		this.navigateFirstPage = navigateFirstPage;
	}


	public Integer getNavigateLastPage() {
		return navigateLastPage;
	}


	public void setNavigateLastPage(Integer navigateLastPage) {
		this.navigateLastPage = navigateLastPage;
	}
	
	
	
	
	
	
	
}



/*
//当前页
  private int pageNum;
  //每页的数量
  private int pageSize;
  //当前页的数量
  private int size;
  //排序
  private String orderBy;

  //由于startRow和endRow不常用，这里说个具体的用法
  //可以在页面中"显示startRow到endRow 共size条数据"

  //当前页面第一个元素在数据库中的行号
  private int startRow;
  //当前页面最后一个元素在数据库中的行号
  private int endRow;
  //总记录数
  private long total;
  //总页数
  private int pages;
  //结果集
  private List<T> list;

  //第一页
  private int firstPage;
  //前一页
  private int prePage;
  //下一页
  private int nextPage;
  //最后一页
  private int lastPage;

  //是否为第一页
  private boolean isFirstPage = false;
  //是否为最后一页
  private boolean isLastPage = false;
  //是否有前一页
  private boolean hasPreviousPage = false;
  //是否有下一页
  private boolean hasNextPage = false;
  //导航页码数
  private int navigatePages;
  //所有导航页号
  private int[] navigatepageNums;
* */
















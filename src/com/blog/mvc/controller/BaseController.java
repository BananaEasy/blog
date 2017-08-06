package com.blog.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class BaseController {

	@Resource
	protected ServletContext application;
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		/**
		 * 自动转换日期类型的字段格式
		 */
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
	
	public static  String rootPath  = "";
	
	static {
		rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		rootPath = rootPath.substring(0,rootPath.lastIndexOf("W")-1);
		System.out.println(rootPath + "-------------------------------------");
	}
	
}

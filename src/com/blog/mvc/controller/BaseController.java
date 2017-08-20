package com.blog.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class BaseController {

	private static Log log = LogFactory.getLog(BaseController.class);

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
		try{
			String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			rootPath = path.substring(0,path.lastIndexOf("W")-1);
		}catch (Exception e){
			log.error("web路径加载失败");
		}
		System.out.println(rootPath + "-------------------------------------");
	}
	
}

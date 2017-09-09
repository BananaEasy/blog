package com.blog.mvc;

import com.blog.model.LoginUser;
import com.blog.model.SiteMap;
import com.blog.mvc.controller.BaseController;
import com.blog.tool.JsonPares;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Constant {
	
	/**  文章条木显示个数  **/
	private static Log log  = LogFactory.getLog(Constant.class);
	
	public static Integer ARTICLE_ITEM_LENGTH = 8;


	public static List<LoginUser> users = null ;

	public static SiteMap siteMap = null;


	public static String userJsonPath = BaseController.rootPath
			+ File.separator + "WEB-INF"
			+ File.separator + "resoce"
			+ File.separator + "User.json" ;

	public static String seoJsonPath = BaseController.rootPath
			+ File.separator + "WEB-INF"
			+ File.separator + "resoce"
			+ File.separator + "SiteMap.json" ;


	static {
		log.info("加载json 文件");
		users =  JsonPares.pares(userJsonPath,new TypeToken<List<LoginUser>>(){}.getType());
		siteMap= JsonPares.pares(seoJsonPath,new TypeToken<SiteMap>(){}.getType());
		log.info("Users:" + users);
		log.info("siteMap:" + siteMap);
	}

}

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


	public static String userJsonPath = BaseController.rootPath
			+ File.separator + "WEB-INF"
			+ File.separator + "resoce"
			+ File.separator + "User.json" ;

	public static String seoJsonPath = BaseController.rootPath
			+ File.separator + "WEB-INF"
			+ File.separator + "resoce"
			+ File.separator + "SiteMap.json" ;

	public static List<LoginUser> getUsers() {
		return JsonPares.pares(userJsonPath,new TypeToken<List<LoginUser>>(){}.getType());
	}

	public static SiteMap getSiteMap() {
		return JsonPares.pares(seoJsonPath,new TypeToken<SiteMap>(){}.getType());
	}

}

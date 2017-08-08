package com.blog.mvc;

import com.blog.model.LoginUser;
import com.blog.mvc.controller.BaseController;
import com.blog.mvc.entity.User;
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
	
	
	public static Integer ARTICLE_ITEM_LENGTH = 8;


	public static List<LoginUser> users = null ;

	private static String jsonPath = BaseController.rootPath
			+ File.separator + "WEB-INF"
			+ File.separator + "resoce"
			+ File.separator + "User.json" ;

	private static Log log  = LogFactory.getLog(Constant.class);


	static {
		Type type = new TypeToken<List<LoginUser>>(){}.getType();
		log.info("读取缓存列表" + type );
		JsonReader reader = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		log.info("加载Json文件到内存中FilePath:" + jsonPath );
		try {
			fis = new FileInputStream(new File(jsonPath));
			isr = new InputStreamReader(fis,"UTF-8");
			reader = new JsonReader(isr);
			reader.setLenient(true);
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			List<LoginUser> list = gson.fromJson(reader, type);
			users = Collections.synchronizedList(new ArrayList<>(list));
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try{
				if(isr!=null){
					isr.close();
				}
				if(fis!=null){
					fis.close();
				}
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}

	}


}

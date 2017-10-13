package xyz.lihang.blog.mvc;

import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.lihang.blog.model.LoginUser;
import xyz.lihang.blog.model.SiteMap;
import xyz.lihang.blog.tool.utils.PathUtils;
import xyz.lihang.blog.tool.JsonPares;
import java.io.File;
import java.util.List;

/**
 *
 */
public class Constant {
	
	/**  文章条木显示个数  **/
	private static Logger log = LoggerFactory.getLogger(Constant.class);
	
	public static Integer ARTICLE_ITEM_LENGTH = 8;


	public static String userJsonPath = PathUtils.getClassesPath()
			+ File.separator + "json"
			+ File.separator + "User.json" ;

	public static String seoJsonPath = PathUtils.getClassesPath()
			+ File.separator + "json"
			+ File.separator + "SiteMap.json" ;

	public static List<LoginUser> getUsers() {
		return JsonPares.pares(userJsonPath,new TypeToken<List<LoginUser>>(){}.getType());
	}

	public static SiteMap getSiteMap() {
		return JsonPares.pares(seoJsonPath,new TypeToken<SiteMap>(){}.getType());
	}

}

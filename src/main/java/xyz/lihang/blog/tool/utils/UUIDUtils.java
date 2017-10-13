package xyz.lihang.blog.tool.utils;

import java.util.UUID;

/**
 * UUID工具类
 */
public class UUIDUtils {
	   public static String getUUID(){
	         return UUID.randomUUID().toString().replace("-", "");
	    }
}

package com.blog.mvc.utils;

import org.apache.commons.lang.StringUtils;

public class FileUtils {
	
	/**
	 * 解析文件的文件后缀
	 * @param fileName
	 * @return .123123
	 */
	public static  String parseSuffix (String fileName){
		if(StringUtils.isNotBlank(fileName)){
			int index = fileName.lastIndexOf('.');
			if(index != -1){
				return fileName.substring(index);
			}
		}
		return "";
	}
	
	public static boolean isWhiteList(String suffix,String [] whiteList){
		if(StringUtils.isBlank(suffix))
			return false;
		for(String s : whiteList){
			if(s.equals(suffix)){
				return true;
			}
		}
		return false;
	}
}

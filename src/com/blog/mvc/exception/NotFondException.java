package com.blog.mvc.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NotFondException extends RuntimeException{
	
	
	public static Log log  =LogFactory.getLog( NotFondException.class);
	
	public NotFondException(String message) {
		super(message);
		log.error("指定资源不存在 --- > "  + message);
	}
}

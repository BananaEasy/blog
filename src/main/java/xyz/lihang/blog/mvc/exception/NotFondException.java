package xyz.lihang.blog.mvc.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotFondException extends RuntimeException{
	
	
	public static Logger log = LoggerFactory.getLogger( NotFondException.class);
	
	public NotFondException(String message) {
		super(message);
		log.error("指定资源不存在 --- > "  + message);
	}
}

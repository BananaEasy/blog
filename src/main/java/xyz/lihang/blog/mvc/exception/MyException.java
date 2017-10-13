package xyz.lihang.blog.mvc.exception;


/**
 * 用于返回业务层校验返回的字符串数据
 * @author LiHang
 *
 */
public class MyException extends RuntimeException {
	private String errorMsg;

	
	
	public MyException() {
		super();
	}



	public MyException(String message) {
		super(message);
		this.errorMsg = message;
	}



	public String getErrorMsg() {
		return errorMsg;
	}
	
	
	
}

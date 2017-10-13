package xyz.lihang.blog.annotation;

import java.lang.annotation.*;


/**
 * 拦截Controller 方法注解
 *
 * 对于返回值RenderJson方法进行AOP处理
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RenderJsonInvok {
	String errorMsg() default "";
}

package com.blog.mvc.aop;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.blog.annotation.ControllerInvok;

@Aspect    
@Component
public class ControllerAspectJ {
	
	private static final Log log = LogFactory.getLog(ControllerAspectJ.class);
	
	public ControllerAspectJ(){
	}

    //Controller层切点    
    @Pointcut("@annotation(com.blog.annotation.ControllerInvok)")    
     public  void controllerAspect() {    
    }    

    
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")    
    public void controllerBefor(JoinPoint joinPoint, Throwable e) {
    	try {
    	
    		//获取方法信息
			String description = getControllerMethodDescription(joinPoint);
			
			System.out.println(description);
			
			
			
		} catch (Exception ee) {
			ee.printStackTrace();
			log.error(ee.getMessage());
		}
    	
    	
    }
    
    
    
    
    
    
    /**  
     * 获取注解中对方法的描述信息 用于Controller层注解  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(ControllerInvok. class).description();    
                     break;    
                }    
            }    
        }    
         return description;    
    }    

}

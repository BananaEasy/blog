package com.blog.mvc.aop;

import com.blog.annotation.ControllerInvok;
import com.blog.annotation.RenderJsonInvok;
import com.blog.mvc.utils.RenderJson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class RenderJsonAspectJ {

	private static final Log log = LogFactory.getLog(RenderJsonAspectJ.class);

	public RenderJsonAspectJ(){
        log.info("AOP创建");
	}

    //Controller层切点    
    @Pointcut("@annotation(com.blog.annotation.RenderJsonInvok)")
    public  void controllerAspect() {

    }





    /**
     * 环绕通知
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        Object object ;
        try {

            object = pjp.proceed();

        }catch (Exception e){
            log.info(pjp.getTarget() + e.getMessage());

            RenderJson renderJson = RenderJson.Instance();

            String errorMsg = getControllerMethodDescription(pjp);

            if(errorMsg.isEmpty()){
                object =  renderJson.defaultErrorMessage().ERROR();
            }else{
                object =  renderJson.ERROR().setMessage(errorMsg);
            }
        }
        return object;
    }


    
    /**  
     * 获取注解中对方法的描述信息 用于返回Controller层方法RenderJsonInvok注解
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
                    description = method.getAnnotation(RenderJsonInvok.class).errorMsg();
                     break;    
                }    
            }    
        }    
         return description;    
    }    

}

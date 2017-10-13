package xyz.lihang.blog.mvc.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import xyz.lihang.blog.annotation.RenderJsonInvok;
import xyz.lihang.blog.mvc.exception.MyException;
import xyz.lihang.blog.tool.utils.RenderJson;
import java.lang.reflect.Method;

@Aspect
@Component
public class RenderJsonAspectJ {

	private static final Logger log = LoggerFactory.getLogger(RenderJsonAspectJ.class);

	public RenderJsonAspectJ(){
        log.info("AOP创建");
	}

    //Controller层切点    
    @Pointcut("@annotation(xyz.lihang.blog.annotation.RenderJsonInvok)")
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
            log.info("Class: " +  pjp.getTarget() + "\tMethod:"+ pjp.getSignature().getName() + "\tErorrMsg:" + e.getMessage());

            RenderJson renderJson = RenderJson.Instance().ERROR();

            if(e instanceof MyException){
                return renderJson.setMessage(((MyException) e).getErrorMsg()).ERROR();
            }
            String errorMsg = getControllerMethodDescription(pjp);
            if(errorMsg.isEmpty()){
                object =  renderJson.defaultErrorMessage();
            }else{
                object =  renderJson.setMessage(errorMsg);
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
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = joinPoint.getTarget().getClass();
        String description = "";
         for (Method method : targetClass.getMethods()) {
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                if (clazzs.length == arguments.length) {     //防止方法重载
                    description = method.getAnnotation(RenderJsonInvok.class).errorMsg();
                     break;    
                }    
            }    
        }    
        return description;
    }    

}

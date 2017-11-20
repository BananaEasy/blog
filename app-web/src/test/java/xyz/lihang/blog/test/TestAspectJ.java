package xyz.lihang.blog.test;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import xyz.lihang.blog.common.tool.annotation.ControllerInvok;


/**
 * AOP测试
 */
//@Aspect
//@Component
public class TestAspectJ {
	
	private static final Logger log = LoggerFactory.getLogger(((TestAspectJ.class)));
	
	public TestAspectJ(){
        log.info("AOP创建");
	}

    //Controller层切点    
    //@Pointcut("@annotation(xyz.lihang.blog.annotation.ControllerInvok)")
    //@Pointcut("execution(* MainController.*(..))")
    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public  void controllerAspect() {

    }


    /**
     * 前置通知（Before advice） ：在某连接点（JoinPoint）之前执行的通知，但这个通知不能阻止连接点前的执行。
     * @param joinPoint
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint)
    {
        System.out.println("=====前置通知开始=====");
        //handleLog(joinPoint, null);
    }

    /**
     * 后通知（After advice） ：当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。
     * @param joinPoint
     */
    @AfterReturning(pointcut = "controllerAspect()")
    public void doAfter(JoinPoint joinPoint)
    {
        System.out.println("=====后置通知开始=====");
        //handleLog(joinPoint, null);
    }

    /**
     * 抛出异常后通知（After throwing advice） ： 在方法抛出异常退出时执行的通知。
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "controllerAspect()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e)
    {
        System.out.println("=====异常通知开始=====");
    }



    /**
     * 方法开始执行
     */
    @Before("controllerAspect()")
    public void doBefore(){
        System.out.println("开始");
    }


    /**
     * 方法执行
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        Object object = null;
        try {
            object = pjp.proceed();
        }catch (Exception e){
            log.info(pjp.getTarget() + e.getMessage());
            throw e;
        }
        return object;
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
                    description = method.getAnnotation(ControllerInvok.class).description();
                     break;    
                }    
            }    
        }    
         return description;    
    }    

}

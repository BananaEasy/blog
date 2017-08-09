package com.blog.mvc.aop;

import com.blog.annotation.ControllerInvok;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * Controller 日志  Aop
 */
@Aspect
@Component
public class ControllerAspectJ {

	private  final Log log = LogFactory.getLog(getClass());

	public ControllerAspectJ(){
        log.info("Controller 日志  Aop创建");
	}

    //Controller层切点    
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
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        log.info("ClassName:" + targetName +"--------Method:"+ methodName);
    }

}

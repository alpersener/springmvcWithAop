package com.project.crudwithaop.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger= Logger.getLogger(getClass().getName());

    @Before("com.project.crudwithaop.aspect.AopExpressions.forApp()")
    public void before(JoinPoint joinPoint){
        String method=joinPoint.getSignature().toShortString();
        logger.info("------->@Before Advice ve method:"+method);

        Object[] args=joinPoint.getArgs();
        for(Object arguments:args){
            logger.info("---->arguments:"+arguments);
        }


    }


    @AfterReturning(pointcut ="com.project.crudwithaop.aspect.AopExpressions.forApp()",
    returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String method=joinPoint.getSignature().toShortString();
        logger.info("------->@AfterReturning Advice ve method:"+method);
        logger.info("------->result:"+result);

    }
}

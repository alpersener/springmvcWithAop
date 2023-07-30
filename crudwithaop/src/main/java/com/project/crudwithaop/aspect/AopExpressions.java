package com.project.crudwithaop.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.project.crudwithaop.controller.*.*(..))")
    public void forController(){}
    @Pointcut("execution(* com.project.crudwithaop.service.*.*(..))")
    public void forService(){}
    @Pointcut("execution(* com.project.crudwithaop.repository.*.*(..))")
    public void forRepository(){}
    @Pointcut("forController() || forRepository() || forService()")
    public void forApp(){}




}

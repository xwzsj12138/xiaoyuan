package com.wm.project.project.config;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class AnnoDemo2MethredAspect {

    @Pointcut("@annotation(com.wm.project.project.config.AnnoDemo2Methred)") //2.切入点表达式，标明原始方法位置
    public void point(){
        System.out.println("切点");
    }

//    @Before("@annotation(com.wm.project.project.config.AnnoDemo2Methred)")
//    public void before(ProceedingJoinPoint point){
//        System.out.println("befo0");
//        System.out.println("point====="+point.getSignature()+"========="+ Arrays.asList(point.getArgs()) );
//
//    }

    @Around("@annotation(com.wm.project.project.config.AnnoDemo2Methred)")
    public Object Around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("Around");
        System.out.println("point====="+point.getSignature()+"========="+ Arrays.asList(point.getArgs()) );
        System.out.println("方法"+point.getSignature().getName());
        System.out.println("返回值"+point.proceed());

       return point.proceed();
    }
}

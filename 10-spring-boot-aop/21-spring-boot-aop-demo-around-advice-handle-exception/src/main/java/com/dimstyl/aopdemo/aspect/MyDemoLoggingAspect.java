package com.dimstyl.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    @Around("execution(* com.dimstyl.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("=====>>> Executing aroundGetFortune()");
        long begin = System.currentTimeMillis();
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("=====>>> Exception is: " + e.getMessage());
            result = "Major accident! But no worries, your private AOP helicopter is on the way!";
        }
        long end = System.currentTimeMillis();
        System.out.println("=====>>> Duration: " + (end - begin) / 1000.0 + " seconds");
        return result;
    }
}

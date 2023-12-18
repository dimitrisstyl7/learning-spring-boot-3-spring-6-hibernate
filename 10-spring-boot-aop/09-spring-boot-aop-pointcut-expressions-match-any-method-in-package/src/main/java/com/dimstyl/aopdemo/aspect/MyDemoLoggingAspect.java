package com.dimstyl.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Before("execution(* com.dimstyl.aopdemo.dao.impl.*.*(..))")
    public void beforeAnyDaoMethodAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method");
    }
}

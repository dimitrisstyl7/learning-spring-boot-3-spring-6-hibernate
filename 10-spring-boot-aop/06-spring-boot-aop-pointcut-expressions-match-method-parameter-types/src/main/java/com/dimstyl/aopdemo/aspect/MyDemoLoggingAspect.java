package com.dimstyl.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Before("execution(* add*(com.dimstyl.aopdemo.Account))")
    public void beforeAddStarWithSpecificParamTypeAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on add* method with specific parameter type");
    }
}

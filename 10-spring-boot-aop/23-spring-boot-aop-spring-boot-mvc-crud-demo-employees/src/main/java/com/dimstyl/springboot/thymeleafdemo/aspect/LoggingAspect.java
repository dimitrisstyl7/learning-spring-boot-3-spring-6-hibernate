package com.dimstyl.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.dimstyl.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.dimstyl.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.dimstyl.springboot.thymeleafdemo.repository.*.*(..))")
    private void forRepositoryPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forRepositoryPackage()")
    private void forAppFlow() {
    }

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        // display the method we are calling
        logger.info("=====> in @Before: calling method: " + joinPoint.getSignature().toShortString());

        // display the arguments
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(arg -> logger.info("=====> argument: " + arg));

    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        // display the method we are returning from
        logger.info("=====> in @AfterReturning: from method: " + joinPoint.getSignature().toShortString());

        // display data returned
        logger.info("=====> result: " + result);
    }
}

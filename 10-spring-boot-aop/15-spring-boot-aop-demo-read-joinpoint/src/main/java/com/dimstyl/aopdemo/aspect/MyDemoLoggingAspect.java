package com.dimstyl.aopdemo.aspect;

import com.dimstyl.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    @Before("com.dimstyl.aopdemo.aspect.AopExpressionsUtil.forDaoPackageNoGetterSetter()")
    public void beforeAnyDaoMethodAdvice(JoinPoint joinPoint) {
        System.out.println("=====>>> Executing my beforeAnyDaoMethodAdvice()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("\tMethod signature: " + methodSignature);

        // display method arguments
        Object[] args = joinPoint.getArgs();

        Arrays.stream(args).forEach(arg -> {
            System.out.println("\tMethod argument: " + arg);

            if (arg instanceof Account account) {
                System.out.println("\tAccount name: " + account.getName());
                System.out.println("\tAccount level: " + account.getLevel());
            }
        });

/*                for (Object arg : args) {
            System.out.println("Method argument: " + arg);

            if (arg instanceof Account account) {
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }*/
    }
}

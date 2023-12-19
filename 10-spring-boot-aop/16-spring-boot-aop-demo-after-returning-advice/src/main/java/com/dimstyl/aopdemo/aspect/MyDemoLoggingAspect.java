package com.dimstyl.aopdemo.aspect;

import com.dimstyl.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    @AfterReturning(
            pointcut = "execution(* com.dimstyl.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        System.out.println("=====>>> Executing afterReturningFindAccountsAdvice()");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("\tMethod signature: " + methodSignature.toShortString());
        System.out.println("\tresult is: " + result);
    }

    @Before("com.dimstyl.aopdemo.aspect.AopExpressionsUtil.forDaoPackageNoGetterSetter()")
    public void beforeAnyDaoMethodAdvice(JoinPoint joinPoint) {
        System.out.println("=====>>> Executing beforeAnyDaoMethodAdvice()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("\tMethod signature: " + methodSignature.toShortString());

        // display method arguments
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(arg -> {
            System.out.println("\tMethod argument: " + arg);

            if (arg instanceof Account account) {
                System.out.println("\tAccount name: " + account.getName());
                System.out.println("\tAccount level: " + account.getLevel());
            }
        });
    }
}

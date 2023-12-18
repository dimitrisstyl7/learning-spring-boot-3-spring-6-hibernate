package com.dimstyl.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Before("execution(public void com.dimstyl.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAccountDaoAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on accountDao.addAccount()");
    }
}

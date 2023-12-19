package com.dimstyl.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopExpressionsUtil {
    @Pointcut("execution(* com.dimstyl.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* com.dimstyl.aopdemo.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* com.dimstyl.aopdemo.dao.*.set*(..))")
    public void setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {
    }
}

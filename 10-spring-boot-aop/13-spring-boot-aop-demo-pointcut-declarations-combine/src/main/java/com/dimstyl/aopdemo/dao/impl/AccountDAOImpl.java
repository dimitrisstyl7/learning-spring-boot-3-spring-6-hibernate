package com.dimstyl.aopdemo.dao.impl;

import com.dimstyl.aopdemo.Account;
import com.dimstyl.aopdemo.dao.AccountDAO;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name, serviceCode;

    public String getName() {
        System.out.println(getClass() + ": getName()\n");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()\n");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()\n");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()\n");
        this.serviceCode = serviceCode;
    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT\n");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()\n");
        return false;
    }
}

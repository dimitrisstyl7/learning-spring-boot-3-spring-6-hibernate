package com.dimstyl.aopdemo.dao.impl;

import com.dimstyl.aopdemo.Account;
import com.dimstyl.aopdemo.dao.AccountDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(Boolean tripWire) {
        // simulate an exception
        if (tripWire) {
            throw new RuntimeException("Haha! Exception!");
        }

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Jerry", "Silver"));
        accounts.add(new Account("Tom", "Gold"));
        accounts.add(new Account("Mickey", "Bronze"));
        return accounts;
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

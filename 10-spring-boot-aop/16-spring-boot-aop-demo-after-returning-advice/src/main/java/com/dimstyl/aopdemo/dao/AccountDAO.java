package com.dimstyl.aopdemo.dao;

import com.dimstyl.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account account, boolean vip);

    boolean doWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

    List<Account> findAccounts();
}

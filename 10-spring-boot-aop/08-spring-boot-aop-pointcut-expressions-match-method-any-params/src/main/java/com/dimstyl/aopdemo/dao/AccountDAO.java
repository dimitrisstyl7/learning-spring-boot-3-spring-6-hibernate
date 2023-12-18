package com.dimstyl.aopdemo.dao;

import com.dimstyl.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vip);
}

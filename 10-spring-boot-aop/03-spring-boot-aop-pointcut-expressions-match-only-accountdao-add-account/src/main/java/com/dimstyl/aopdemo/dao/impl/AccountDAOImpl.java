package com.dimstyl.aopdemo.dao.impl;

import com.dimstyl.aopdemo.dao.AccountDAO;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}

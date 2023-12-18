package com.dimstyl.aopdemo.dao.impl;

import com.dimstyl.aopdemo.dao.MembershipDAO;
import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public boolean addMember() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }

    @Override
    public boolean sayHi() {
        System.out.println(getClass() + ": SAYING HI");
        return false;
    }
}

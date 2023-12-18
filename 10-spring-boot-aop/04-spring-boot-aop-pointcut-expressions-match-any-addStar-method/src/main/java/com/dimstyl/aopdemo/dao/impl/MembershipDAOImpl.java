package com.dimstyl.aopdemo.dao.impl;

import com.dimstyl.aopdemo.dao.MembershipDAO;
import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addMember() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
    }
}

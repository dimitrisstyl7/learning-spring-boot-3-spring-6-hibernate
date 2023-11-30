package com.dimstyl.cruddemo.dao.impl;


import com.dimstyl.cruddemo.dao.EmployeeDao;
import com.dimstyl.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        var x = entityManager.createQuery("from Employee", Employee.class).getResultList();
        return x;
    }
}

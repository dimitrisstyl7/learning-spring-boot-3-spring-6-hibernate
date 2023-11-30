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
        return entityManager.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        /*entityManager.createQuery("delete from Employee where id=:employeeId")
                .setParameter("employeeId", id)
                .executeUpdate();*/

        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}

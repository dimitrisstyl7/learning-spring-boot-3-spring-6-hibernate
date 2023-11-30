package com.dimstyl.cruddemo.dao;

import com.dimstyl.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
}

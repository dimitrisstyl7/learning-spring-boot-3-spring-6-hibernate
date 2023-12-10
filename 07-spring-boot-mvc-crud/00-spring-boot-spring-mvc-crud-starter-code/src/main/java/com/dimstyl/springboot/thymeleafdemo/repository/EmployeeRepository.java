package com.dimstyl.springboot.thymeleafdemo.repository;

import com.dimstyl.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

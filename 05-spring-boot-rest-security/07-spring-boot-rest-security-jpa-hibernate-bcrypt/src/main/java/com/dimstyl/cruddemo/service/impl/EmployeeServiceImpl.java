package com.dimstyl.cruddemo.service.impl;

import com.dimstyl.cruddemo.entity.Employee;
import com.dimstyl.cruddemo.repository.EmployeeRepository;
import com.dimstyl.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> employee = employeeRepository.findById(theId);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}







package com.dimstyl.cruddemo.dao;

import com.dimstyl.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(int id);
}

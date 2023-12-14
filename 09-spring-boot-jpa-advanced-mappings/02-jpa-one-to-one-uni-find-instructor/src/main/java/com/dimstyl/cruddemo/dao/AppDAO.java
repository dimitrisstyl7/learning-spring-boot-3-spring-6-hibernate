package com.dimstyl.cruddemo.dao;

import com.dimstyl.cruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);
}

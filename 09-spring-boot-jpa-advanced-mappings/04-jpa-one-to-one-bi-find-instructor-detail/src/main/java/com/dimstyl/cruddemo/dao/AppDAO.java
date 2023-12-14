package com.dimstyl.cruddemo.dao;

import com.dimstyl.cruddemo.entity.Instructor;
import com.dimstyl.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);
}

package com.dimstyl.cruddemo;

import com.dimstyl.cruddemo.dao.StudentDAO;
import com.dimstyl.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);
            //createMultipleStudents(studentDAO);
            findStudent(studentDAO);
        };
    }

    private void findStudent(StudentDAO studentDAO) {
        int id = 6;
        System.out.println("Finding student with id " + id + "...");
        Student student = studentDAO.findById(id);
        System.out.println("Found student: " + student);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating 2 new students...");
        Student student1 = new Student("Ann", "Smith", "ann@email.com");
        Student student2 = new Student("Mary", "Public", "mary@email.com");
        System.out.println("Saving students...");
        studentDAO.save(student1);
        studentDAO.save(student2);
        System.out.println("Students saved with ids: " + student1.getId() + ", " + student2.getId());
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student...");
        Student student = new Student("John", "Doe", "test@email.com");
        System.out.println("Saving student...");
        studentDAO.save(student);
        System.out.println("Student saved with id: " + student.getId());
    }
}

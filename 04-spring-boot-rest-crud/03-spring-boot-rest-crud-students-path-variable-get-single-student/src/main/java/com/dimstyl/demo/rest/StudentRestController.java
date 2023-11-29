package com.dimstyl.demo.rest;

import com.dimstyl.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    // define @PostConstruct to load the student data only once
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Mario", "Doe"));
        students.add(new Student("John", "Smith"));
        students.add(new Student("Mary", "White"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // The studentId is the index position of the student in the list
        return students.get(studentId);
    }
}

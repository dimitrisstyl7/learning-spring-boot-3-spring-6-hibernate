package com.dimstyl.springboot.thymeleafdemo.controller;

import com.dimstyl.springboot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @GetMapping("/studentForm")
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-form";
    }

    @PostMapping("processStudentForm")
    public String processForm(@ModelAttribute("student") Student student) {
        return "student-confirmation";
    }
}

package com.dimstyl.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld2";
    }

    @RequestMapping("/shout")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName").toUpperCase();
        model.addAttribute("message", "Yo! " + name);
        return "helloworld2";
    }

    @RequestMapping("/shout2")
    public String letsShoutDude2(@RequestParam("studentName") String studentName, Model model) {
        model.addAttribute("message", "Hey my friend " + studentName.toUpperCase());
        return "helloworld2";
    }
}

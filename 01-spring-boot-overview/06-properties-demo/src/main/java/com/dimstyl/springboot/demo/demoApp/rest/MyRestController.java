package com.dimstyl.springboot.demo.demoApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @Value("${person.fullName}")
    private String fullName;

    @Value("${person.age}")
    private String age;

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5km!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day!";
    }

    @GetMapping("/person-info")
    public String getPersonInfo() {
        return "Full name: " + fullName + ", age: " + age;
    }
}

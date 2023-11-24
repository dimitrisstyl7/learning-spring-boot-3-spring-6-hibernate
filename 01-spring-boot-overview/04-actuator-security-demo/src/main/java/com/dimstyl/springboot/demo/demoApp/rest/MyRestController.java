package com.dimstyl.springboot.demo.demoApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
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
}

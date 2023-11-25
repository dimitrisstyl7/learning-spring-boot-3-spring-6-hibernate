package com.dimstyl.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("CricketCoach: postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("CricketCoach: preDestroy");
    }
}

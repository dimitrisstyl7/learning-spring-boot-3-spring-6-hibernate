package com.dimstyl.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    public TennisCoach() {
        System.out.println("In TennisCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }
}

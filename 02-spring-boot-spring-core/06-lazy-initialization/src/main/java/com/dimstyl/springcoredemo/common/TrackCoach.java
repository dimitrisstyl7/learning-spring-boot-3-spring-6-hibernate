package com.dimstyl.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    public TrackCoach() {
        System.out.println("In TrackCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k.";
    }
}

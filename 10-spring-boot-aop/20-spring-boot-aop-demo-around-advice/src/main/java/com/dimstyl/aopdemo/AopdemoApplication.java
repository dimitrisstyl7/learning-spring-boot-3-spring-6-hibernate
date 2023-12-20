package com.dimstyl.aopdemo;

import com.dimstyl.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TrafficFortuneService trafficFortuneService) {
        return runner -> {
            demoTheAroundAdvice(trafficFortuneService);
        };
    }

    private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println("\n\nMain Program: demoTheAroundAdvice");
        System.out.println("----");
        System.out.println("Calling getFortune()");
        System.out.println("\nMy fortune is: " + trafficFortuneService.getFortune());
        System.out.println("Main Program: Finished");
    }
}

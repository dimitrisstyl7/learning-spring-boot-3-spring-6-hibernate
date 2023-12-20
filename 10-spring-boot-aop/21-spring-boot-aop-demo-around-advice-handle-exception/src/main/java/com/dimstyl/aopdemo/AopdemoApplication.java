package com.dimstyl.aopdemo;

import com.dimstyl.aopdemo.dao.AccountDAO;
import com.dimstyl.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountDAO accountDAO, TrafficFortuneService trafficFortuneService) {
        return runner -> {
//            demoTheAfterReturningAdvice(accountDAO);
//            demoTheAfterThrowingAdvice(accountDAO);
//            demoTheAroundAdvice(trafficFortuneService);
            demoTheAroundAdviceHandleException(trafficFortuneService);
        };
    }

    private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
        System.out.println("\n\nMain Program: demoTheAroundAdviceHandleException");
        System.out.println("----");
        System.out.println("Calling getFortune()");
        System.out.println("\nMy fortune is: " + trafficFortuneService.getFortune(true));
        System.out.println("Main Program: Finished");
    }

    private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println("\n\nMain Program: demoTheAroundAdvice");
        System.out.println("----");
        System.out.println("Calling getFortune()");
        System.out.println("\nMy fortune is: " + trafficFortuneService.getFortune());
        System.out.println("Main Program: Finished");
    }

    private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;

        try {
            accounts = accountDAO.findAccounts(true);

        } catch (Exception e) {
            System.out.println("\nMain Program: Caught exception: " + e);
        }

        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("----");
        System.out.println(accounts);
        System.out.println("\n");
    }

    private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
        List<Account> accounts = accountDAO.findAccounts();
        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println("----");
        System.out.println(accounts);
        System.out.println("\n");
    }
}

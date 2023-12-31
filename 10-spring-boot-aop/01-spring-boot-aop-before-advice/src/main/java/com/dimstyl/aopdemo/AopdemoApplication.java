package com.dimstyl.aopdemo;

import com.dimstyl.aopdemo.dao.AccountDAO;
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
    CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
        return runner -> {
            demoTheBeforeAdvice(accountDAO);
        };
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO) {
        accountDAO.addAccount();
    }
}

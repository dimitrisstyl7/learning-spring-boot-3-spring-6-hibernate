package com.dimstyl.aopdemo;

import com.dimstyl.aopdemo.dao.AccountDAO;
import com.dimstyl.aopdemo.dao.MembershipDAO;
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
    CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> {
            demoTheBeforeAdvice(accountDAO, membershipDAO);
        };
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        accountDAO.addAccount(new Account("John", "Platinum"), true);
        accountDAO.doWork();

        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        accountDAO.getName();
        accountDAO.getServiceCode();

        membershipDAO.addMember();
        membershipDAO.sayHi();
    }
}

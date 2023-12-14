package com.dimstyl.cruddemo;

import com.dimstyl.cruddemo.dao.AppDAO;
import com.dimstyl.cruddemo.entity.Instructor;
import com.dimstyl.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createInstructor(appDAO);
//            findInstructor(appDAO);
            deleteInstructor(appDAO);
        };
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 2;
        System.out.println("Deleting instructor with id: " + id + "...");

        appDAO.deleteInstructorById(id);
        System.out.println("Instructor deleted!");
    }

    private void findInstructor(AppDAO appDAO) {
        int id = 2;
        System.out.println("Finding instructor with id: " + id + "...");

        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Found instructor: " + instructor);

        System.out.println("Found instructor detail: " + instructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
        /*Instructor instructor =
                new Instructor("Dim", "Styl", "test@email.com");
        InstructorDetail instructorDetail =
                new InstructorDetail("https://github.com/dimitrisstyl7", "coding");

        instructor.setInstructorDetail(instructorDetail);*/

        Instructor instructor =
                new Instructor("Sam", "Smith", "test@email.com");
        InstructorDetail instructorDetail =
                new InstructorDetail("https://youtube.com", "singing");

        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving instructor: " + instructor);

        // This will also save the instructorDetail object because of CascadeType.ALL
        appDAO.save(instructor);

        System.out.println("Instructor saved!");
    }
}

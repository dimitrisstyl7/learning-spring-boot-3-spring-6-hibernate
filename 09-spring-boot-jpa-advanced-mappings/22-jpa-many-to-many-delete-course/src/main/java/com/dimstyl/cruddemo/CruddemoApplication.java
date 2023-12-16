package com.dimstyl.cruddemo;

import com.dimstyl.cruddemo.dao.AppDAO;
import com.dimstyl.cruddemo.entity.*;
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
//            createCourseAndStudents(appDAO);
//            findCourseAndStudents(appDAO);
//            findStudentAndCourses(appDAO);
//            addMoreCoursesForStudent(appDAO);
            deleteCourse(appDAO);
        };
    }

    private void addMoreCoursesForStudent(AppDAO appDAO) {
        int id = 1;

        System.out.println("Finding student with id: " + id + "...");
        Student student = appDAO.findStudentAndCoursesByStudentId(id);

        student.addCourse(new Course("Python"));
        student.addCourse(new Course("C++"));

        System.out.println("Updating student...");
        appDAO.update(student);

        System.out.println("Student updated!");
    }

    private void findStudentAndCourses(AppDAO appDAO) {
        int id = 1;

        System.out.println("Finding student with id: " + id + "...");
        Student student = appDAO.findStudentAndCoursesByStudentId(id);

        System.out.println("Found student: " + student);
        System.out.println("Courses: " + student.getCourses());

        System.out.println("Done!");
    }

    private void findCourseAndStudents(AppDAO appDAO) {
        int id = 10;

        System.out.println("Finding course with id: " + id + "...");
        Course course = appDAO.findCourseAndStudentsByCourseId(id);

        System.out.println("Found course: " + course);
        System.out.println("Students: " + course.getStudents());

        System.out.println("Done!");
    }

    private void createCourseAndStudents(AppDAO appDAO) {
        System.out.println("Creating course and students...");

        Course course = new Course("Java");
        course.addStudent(new Student("John", "Doe", "test@email.com"));
        course.addStudent(new Student("Mary", "Public", "test2@email.com"));

        System.out.println("Saving course: " + course);
        System.out.println("Students: " + course.getStudents());

        appDAO.save(course);
        System.out.println("Done!");
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int id = 10;
        System.out.println("Deleting course with id: " + id + "...");

        appDAO.deleteCourseById(id);
        System.out.println("Course deleted!");
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        int id = 10;
        System.out.println("Finding course with id: " + id + "...");

        Course course = appDAO.findCourseAndReviewsByCourseId(id);
        System.out.println("Found course: " + course);
        System.out.println("Reviews: " + course.getReviews());

        System.out.println("Retrieved course and reviews successfully!");
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        System.out.println("Creating course and reviews...");

        Course course = new Course("Java");
        course.addReview(new Review("Cool course!"));
        course.addReview(new Review("Awesome course!"));
        course.addReview(new Review("Great course!"));
        course.addReview(new Review("Awful course!"));

        System.out.println("Saving course: " + course);
        System.out.println("Reviews: " + course.getReviews());

        appDAO.save(course);
        System.out.println("Course saved!");
    }

    private void deleteCourse(AppDAO appDAO) {
        int id = 10;
        System.out.println("Deleting course with id: " + id + "...");

        appDAO.deleteCourseById(id);
        System.out.println("Course deleted!");
    }

    private void updateCourse(AppDAO appDAO) {
        int id = 10;
        System.out.println("Finding course with id: " + id + "...");
        Course course = appDAO.findCourseById(id);

        System.out.println("Updating course...");
        course.setTitle("Java 21");
        appDAO.update(course);

        System.out.println("Course updated!");
    }

    private void updateInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor with id: " + id + "...");
        Instructor instructor = appDAO.findInstructorById(id);

        System.out.println("Updating instructor...");
        instructor.setLastName("TESTER");
        appDAO.update(instructor);

        System.out.println("Instructor updated!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor with id: " + id + "...");

        Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
        System.out.println("Found instructor: " + instructor);
        System.out.println("Associated courses: " + instructor.getCourses());

        System.out.println("Done!");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor with id: " + id + "...");

        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Found instructor: " + instructor);

        instructor.setCourses(appDAO.findCoursesByInstructorId(id));
        System.out.println("Associated courses: " + instructor.getCourses());

        System.out.println("Done!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor with id: " + id + "...");

        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Found instructor: " + instructor);
        System.out.println("Associated courses: " + instructor.getCourses());

        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor instructor =
                new Instructor("Dim", "Styl", "test@email.com");
        InstructorDetail instructorDetail =
                new InstructorDetail("https://github.com/dimitrisstyl7", "coding");
        Course course1 = new Course("Java");
        Course course2 = new Course("Kotlin");

        instructor.setInstructorDetail(instructorDetail);
        instructor.addCourse(course1);
        instructor.addCourse(course2);


        System.out.println("Instructor: " + instructor);
        System.out.println("Courses: " + instructor.getCourses());

        // This will also save the instructorDetail object because of CascadeType.ALL
        appDAO.save(instructor);

        System.out.println("Instructor saved!");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int id = 1;
        System.out.println("Deleting instructor detail with id: " + id + "...");

        appDAO.deleteInstructorDetailById(id);
        System.out.println("Instructor detail deleted!");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor detail with id: " + id + "...");

        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
        System.out.println("Found instructor detail: " + instructorDetail);

        System.out.println("Found instructor: " + instructorDetail.getInstructor());
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 1;
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

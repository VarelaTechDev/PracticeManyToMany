package com.example.practicemanytomany;

import com.example.practicemanytomany.Entity.Course;
import com.example.practicemanytomany.Entity.Student;
import com.example.practicemanytomany.Repository.CourseRepository;
import com.example.practicemanytomany.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public DatabaseSeeder(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create students
        Student student1 = new Student();
        student1.setName("John");
        student1.setEmail("john@gmail.com");
        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setName("Jane");
        student2.setEmail("jane@gmail.com");
        studentRepository.save(student2);

        Student student3 = new Student();
        student3.setName("David");
        student3.setEmail("david@gmail.com");
        studentRepository.save(student3);

        // Create courses
        Course course1 = new Course();
        course1.setTitle("Math");
        course1.setDescription("Mathematics Course");
        courseRepository.save(course1);

        Course course2 = new Course();
        course2.setTitle("Science");
        course2.setDescription("Science Course");
        courseRepository.save(course2);

        Course course3 = new Course();
        course3.setTitle("English");
        course3.setDescription("English Course");
        courseRepository.save(course3);

        // Link students and courses
        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        studentRepository.save(student1);

        student2.getCourses().add(course1);
        studentRepository.save(student2);

        student3.getCourses().add(course3);
        studentRepository.save(student3);

        course1.getStudents().add(student1);
        course1.getStudents().add(student2);
        courseRepository.save(course1);

        course2.getStudents().add(student1);
        courseRepository.save(course2);

        course3.getStudents().add(student3);
        courseRepository.save(course3);
    }
}
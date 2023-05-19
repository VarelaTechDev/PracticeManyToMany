package com.example.practicemanytomany.Repository;

import com.example.practicemanytomany.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

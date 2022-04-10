package com.peaksoft.springboot_crud_lms2.repository;

import com.peaksoft.springboot_crud_lms2.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}

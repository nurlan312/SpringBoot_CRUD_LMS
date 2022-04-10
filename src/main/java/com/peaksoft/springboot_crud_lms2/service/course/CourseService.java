package com.peaksoft.springboot_crud_lms2.service.course;

import com.peaksoft.springboot_crud_lms2.model.Course;

import java.util.List;

public interface CourseService {

    Course createCourse(Course course);

    List<Course> getAllCourses();

    Course getByIdCourse(Long id);

    void updateCourse(Course course, Long id);

    void deleteCourse(Long id);
}

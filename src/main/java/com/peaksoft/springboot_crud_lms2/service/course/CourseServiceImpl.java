package com.peaksoft.springboot_crud_lms2.service.course;

import com.peaksoft.springboot_crud_lms2.model.Company;
import com.peaksoft.springboot_crud_lms2.model.Course;
import com.peaksoft.springboot_crud_lms2.repository.CompanyRepository;
import com.peaksoft.springboot_crud_lms2.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final CompanyRepository companyRepository;

    @Override
    public Course createCourse(Course course, Long companyId) {
        Company company = companyRepository.findById(companyId).get();
        course.setCompany(company);
        return repository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @Override
    public Course getByIdCourse(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Course updateCourse(Course course, Long id) {
        Course course1 = repository.getById(id);
        repository.save(course1);
        return course1;
    }

    @Override
    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }
}

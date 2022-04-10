package com.peaksoft.springboot_crud_lms2.api;

import com.peaksoft.springboot_crud_lms2.model.Company;
import com.peaksoft.springboot_crud_lms2.model.Course;
import com.peaksoft.springboot_crud_lms2.service.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequiredArgsConstructor @RequestMapping("api/course")
public class CourseController {

    private final CourseService service;

    @PostMapping("/create")
    public ResponseEntity createCourse(@RequestBody Course course, @RequestParam Long companyId) {
        try {
            return ResponseEntity.ok(service.createCourse(course, companyId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error create method");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(Course course, Long id) {
        Course course1 = service.getByIdCourse(id);
        try {
            return ResponseEntity.ok(service.updateCourse(course1, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error update method");
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity getByIdCourse(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getByIdCourse(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error get by id method");
        }

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity DeleteByIdCourse(@PathVariable Long id) {
        try {
            service.deleteCourse(id);
            return ResponseEntity.ok("Successfully deleted by id: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error delete method");
        }
    }
}

package com.peaksoft.springboot_crud_lms2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Table @Data @AllArgsConstructor @NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course-g")
    @SequenceGenerator(name = "course-g", sequenceName = "course_seq", allocationSize = 1)
    private Long id;
    private String courseName;
    private int duration;
}

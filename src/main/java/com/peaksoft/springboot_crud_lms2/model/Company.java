package com.peaksoft.springboot_crud_lms2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.*;
import java.util.List;

@Entity @Table @Data @AllArgsConstructor @NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company-g")
    @SequenceGenerator(name = "company-g", sequenceName = "company_seq", allocationSize = 1)
    private Long id;
    private String companyName;
    private String locatedCountry;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Course> courses;
}

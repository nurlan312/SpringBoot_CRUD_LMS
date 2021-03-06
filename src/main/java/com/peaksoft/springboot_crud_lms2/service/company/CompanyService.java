package com.peaksoft.springboot_crud_lms2.service.company;

import com.peaksoft.springboot_crud_lms2.model.Company;
import com.peaksoft.springboot_crud_lms2.model.Course;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    Company saveCompany(Company company, Course course);

    List<Company> getAllCompanies();

    Company getByIdCompany(Long id);

    Company updateCompany(Company company, Long id);

    void deleteByIdCompany(Long id);
}

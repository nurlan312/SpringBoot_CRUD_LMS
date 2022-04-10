package com.peaksoft.springboot_crud_lms2.repository;

import com.peaksoft.springboot_crud_lms2.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
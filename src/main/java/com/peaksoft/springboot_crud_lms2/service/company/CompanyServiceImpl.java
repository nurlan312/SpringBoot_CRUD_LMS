package com.peaksoft.springboot_crud_lms2.service.company;

import com.peaksoft.springboot_crud_lms2.model.Company;
import com.peaksoft.springboot_crud_lms2.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    @Override
    public Company saveCompany(Company company) {
        return repository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return repository.findAll();
    }

    @Override
    public Company getByIdCompany(Long id) {
        return repository.getById(id);
    }

    @Override
    public Company updateCompany(Company company, Long id) {
        Company company1 = repository.findById(id).get();
        return repository.save(company1);
    }

    @Override
    public void deleteByIdCompany(Long id) {
        repository.deleteById(id);
    }
}

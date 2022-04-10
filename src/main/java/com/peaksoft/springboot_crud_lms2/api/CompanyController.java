package com.peaksoft.springboot_crud_lms2.api;

import com.peaksoft.springboot_crud_lms2.model.Company;
import com.peaksoft.springboot_crud_lms2.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequiredArgsConstructor @RequestMapping("api/company")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity createCompany(@RequestBody Company company) {
        try {
            companyService.saveCompany(company);
            return ResponseEntity.ok("Company successfully save: \n" + company);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error create method");
        }
    }

    @PutMapping("/update/{id}")
    public Company updateCompany(@RequestBody Company company, @PathVariable Long id) {
            Company company1 = companyService.getByIdCompany(id);
            companyService.updateCompany(company, id);
            return companyService.saveCompany(company1);
    }

//    @GetMapping("/getById/{id}")
//    public ResponseEntity getByIdCompany(@PathVariable Long id) {
//        try {
//            return ResponseEntity.ok(companyService.getByIdCompany(id));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Error getById method");
//        }
//    }

    @GetMapping("/getById/{id}")
    public Company getByIdCompany(@PathVariable Long id) {
        return companyService.getByIdCompany(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity deleteByIdCompany(@PathVariable Long id) {
        try {
            companyService.deleteByIdCompany(id);
            return ResponseEntity.ok("Delete by id: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error delete method");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Company>> getAllCompanies() {
        try {
            return ResponseEntity.ok(companyService.getAllCompanies());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

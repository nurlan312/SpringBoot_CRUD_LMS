package com.peaksoft.springboot_crud_lms2.api;

import com.peaksoft.springboot_crud_lms2.model.Company;
import com.peaksoft.springboot_crud_lms2.model.Course;
import com.peaksoft.springboot_crud_lms2.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequiredArgsConstructor @RequestMapping("api/company")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity createCompany(@RequestBody Company company, Course course) {
        try {
            companyService.saveCompany(company, course);
            return ResponseEntity.ok("Company successfully save: \n" + company);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error create method");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCompany(@RequestBody Company company, @PathVariable Long id) {
            Company company1 = companyService.getByIdCompany(id);
            return ResponseEntity.ok(companyService.updateCompany(company, id));
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

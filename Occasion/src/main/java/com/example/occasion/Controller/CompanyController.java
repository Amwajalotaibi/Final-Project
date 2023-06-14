package com.example.occasion.Controller;

import com.example.occasion.DTO.CompanyDTo;
import com.example.occasion.Model.Company;
import com.example.occasion.Service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/get")
    public ResponseEntity getAllCompany(){
        List<Company> companyList=companyService.getAllCompany();
        return ResponseEntity.status(200).body(companyList);
    }

    @PostMapping("/add")
    public ResponseEntity addCompanyDto(@Valid @RequestBody CompanyDTo companyDTo){
        companyService.addCompany(companyDTo);
        return ResponseEntity.status(200).body("Company added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCompany(@Valid @RequestBody CompanyDTo companyDTo){
        companyService.updateCompany(companyDTo);
        return ResponseEntity.status(200).body("Company Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCompany(@PathVariable Integer id){
        companyService.deleteCompany(id);
        return ResponseEntity.status(200).body("Company deleted");

    }
}

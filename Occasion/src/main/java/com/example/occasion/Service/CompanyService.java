package com.example.occasion.Service;

import com.example.occasion.ApiException.ApiException;
import com.example.occasion.DTO.CompanyDTo;
import com.example.occasion.Model.*;
import com.example.occasion.Repostiroy.AuthRepository;
import com.example.occasion.Repostiroy.CompanyRepository;
import com.example.occasion.Repostiroy.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final AuthRepository authRepository;

    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    public void addCompany(CompanyDTo dTo) {
        MyUser myUser = authRepository.findMyUserById(dTo.getCompany_id());
        if (myUser == null) {
            throw new ApiException("sorry can't add");
        }

        Company company = new Company(null, dTo.getUsername(), dTo.getPassword(), dTo.getRole(), dTo.getCity(), dTo.getTimecatgory(), dTo.getRating(), dTo.getPrice(),null,null,null);
        companyRepository.save(company);
    }

    public void updateCompany(CompanyDTo dTo) {
        MyUser myUser = authRepository.findMyUserById(dTo.getCompany_id());
        if (myUser == null) {
            throw new ApiException("MyUser not found");
        }

        Company company = companyRepository.findCompanyById(dTo.getCompany_id());
        company.setUsername(dTo.getUsername());
        company.setCity(dTo.getCity());
        company.setPrice(dTo.getPrice());
        company.setRole(dTo.getRole());
        company.setPassword(dTo.getPassword());
        companyRepository.save(company);
    }

    public void deleteCompany(Integer id){
        Company company=companyRepository.findCompanyById(id);
        if(company==null)
            throw new ApiException("Company not found");
        companyRepository.delete(company);
    }

    public Company getCompanyByCity(String city) {
        Company company = companyRepository.findCompanyByCity(city);
        if (company == null) {
            throw new ApiException(" not found");
        }
        return company;
    }
    public Company getCompanybytimecatgory(String timecatgory) {
        Company company1 =companyRepository.findCompanyByTimecatgory(timecatgory);
        if (company1 == null) {
            throw new ArithmeticException(" not found ");
        }
        return company1;
    }


    public Company findCompanyByRating(String rating) {
        Company company = companyRepository.findCompanyByRating(rating);
        if (company == null)
            throw new ApiException("Not found");
        companyRepository.save(company);
       return company;
    }


}

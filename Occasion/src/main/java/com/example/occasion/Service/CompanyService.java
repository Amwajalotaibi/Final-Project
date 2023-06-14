package com.example.occasion.Service;

import com.example.occasion.ApiException.ApiException;
import com.example.occasion.DTO.CompanyDTo;
import com.example.occasion.Model.Company;
import com.example.occasion.Model.MyUser;
import com.example.occasion.Repostiroy.AuthRepository;
import com.example.occasion.Repostiroy.CompanyRepository;
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
        Company company = new Company(null, dTo.getUsername(), dTo.getPassword(), dTo.getCity(), dTo.getRole(), dTo.getPrice(), null, null, null);
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
}

package com.example.occasion.Service;

import com.example.occasion.ApiException.ApiException;
import com.example.occasion.Model.Company;
import com.example.occasion.Repostiroy.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    public List<Company> getAllCompany(){

        return companyRepository.findAll();
    }

    public void addCompany(Company company){

        companyRepository.save(company);
    }

    public void updateCompany(Company company,Integer id){
        Company oldCompany=companyRepository.findCompanyById(id);
        if(oldCompany==null){
            throw new ApiException("Company not found");
        }

        oldCompany.setUsername(company.getUsername());

        companyRepository.save(oldCompany);
    }

    public void deleteCompany(Integer id){
        Company company=companyRepository.findCompanyById(id);
        if(company==null){
            throw new ApiException("Company not found");
        }

        companyRepository.delete(company);
    }
}

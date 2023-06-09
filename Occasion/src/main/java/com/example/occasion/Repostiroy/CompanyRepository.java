package com.example.occasion.Repostiroy;

import com.example.occasion.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

    Company findCompanyById(Integer id);

}

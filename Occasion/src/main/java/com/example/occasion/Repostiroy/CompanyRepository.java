package com.example.occasion.Repostiroy;

import com.example.occasion.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

    Company findCompanyById(Integer id);
    Company findCompanyByCity(String city);

    Company findCompanyByTimecatgory(String timecatgory);

    Company findCompanyByRating(String rating);


}

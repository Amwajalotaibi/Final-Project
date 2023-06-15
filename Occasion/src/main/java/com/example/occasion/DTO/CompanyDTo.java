package com.example.occasion.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyDTo {

    private Integer company_id;
    private String username;
    private String password;
    private String role;
    private String city;
    private Integer Price;
    private String timecatgory;
    private String rating;


}

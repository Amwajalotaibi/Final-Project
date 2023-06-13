package com.example.occasion.Repostiroy;

import com.example.occasion.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer getCustomerById(Integer id);
}

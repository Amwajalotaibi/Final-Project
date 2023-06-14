package com.example.occasion.Controller;

import com.example.occasion.DTO.CompanyDTo;
import com.example.occasion.DTO.CustomerDTO;
import com.example.occasion.Model.Customer;
import com.example.occasion.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(customerService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity addCustomerDto(@Valid @RequestBody CustomerDTO customerDTO){
        customerService.addCustomer(customerDTO);
        return ResponseEntity.status(200).body("Company added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomerDTO(@Valid @RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO);
        return ResponseEntity.status(200).body("Customer Updated");
    }

   @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
       return ResponseEntity.status(200).body("Customer deleted");
   }

//    @GetMapping("/get-myorder/{id}")
//    public ResponseEntity getMyOrderOfCustomer(@PathVariable Integer id){
//        return ResponseEntity.status(200).body(customerService.getMyOrderOfCustomer(id));
//    }

//    @PutMapping("/loyalty/{id}")
//    public ResponseEntity loyalty(@PathVariable Integer id){
//        customerService.loyalty(id);
//        return ResponseEntity.status(200).body("Customer got the loyalty discount");
//    }

}

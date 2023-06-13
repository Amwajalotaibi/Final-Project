package com.example.occasion.Service;

import com.example.occasion.ApiException.ApiException;
import com.example.occasion.Model.Customer;
import com.example.occasion.Model.Myorder;
import com.example.occasion.Repostiroy.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAll(){

        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){

        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer customer){
        Customer c = customerRepository.getCustomerById(id);
        if (c == null)
            throw new ApiException("Not found");
        c.setName(customer.getName());
        c.setEmail(customer.getEmail());
        c.setPhoneNumber(customer.getPhoneNumber());
        customerRepository.save(c);
    }

    public void deleteCustomer(Integer id){
        Customer c = customerRepository.getCustomerById(id);
        if (c == null)
            throw new ApiException("Not found");
        customerRepository.delete(c);
    }











//    public Myorder getMyOrderOfCustomer(Integer id){
//        Customer customer = customerRepository.getCustomerById(id);
//        if (customer == null)
//            throw new ApiException("Not found");
//        return customer.getMyorder();
//    }

//    public void loyalty(Integer id){// عرض هذا لو صار انت مسوي عندنا حجزاكثر من مرتين يصير لك خصم٢٠
//        Customer customer = customerRepository.getCustomerById(id);
//        if (customer == null)
//            throw new ApiException("Not found");
//        Integer price = customer.getMyorder().getCmpanyPrice();
//        if (customer.getNumberOfVisit() > 2) {
//            customer.setLoyalty(true);
//            customer.getMyorder().setCompanyPrice(price - (price * 20 / 100));
//            customerRepository.save(customer);
//        }
//        else
//            throw new ApiException("Not enough visits");
//    }
}

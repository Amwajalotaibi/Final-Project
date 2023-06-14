package com.example.occasion.Service;

import com.example.occasion.ApiException.ApiException;
import com.example.occasion.DTO.CustomerDTO;
import com.example.occasion.Model.Company;
import com.example.occasion.Model.Customer;
import com.example.occasion.Model.MyUser;
import com.example.occasion.Model.Myorder;
import com.example.occasion.Repostiroy.AuthRepository;
import com.example.occasion.Repostiroy.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AuthRepository authRepository;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
    public void addCustomer(CustomerDTO dto){
        MyUser myUser=authRepository.findMyUserById(dto.getCustomer_id());
        if(myUser==null){
            throw new ApiException("sorry can't add");
        }
        Customer customer=new Customer(null, dto.getName(), dto.getEmail(), dto.getPassword(), dto.getPhoneNumber(),null,null);
        customerRepository.save(customer);
    }


    public void updateCustomer(CustomerDTO dto){
        MyUser myUser=authRepository.findMyUserById(dto.getCustomer_id());
        if(myUser==null){
            throw new ApiException("MyUser not found");
        }

        Customer customer=customerRepository.getCustomerById(dto.getCustomer_id());
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setPassword(dto.getPassword());
        customerRepository.save(customer);
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

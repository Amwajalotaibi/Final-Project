package com.example.occasion.Service;

import com.example.occasion.ApiException.ApiException;
import com.example.occasion.DTO.CustomerDTO;
import com.example.occasion.Model.Company;
import com.example.occasion.Model.Customer;
import com.example.occasion.Model.MyUser;
import com.example.occasion.Model.Myorder;
import com.example.occasion.Repostiroy.AuthRepository;
import com.example.occasion.Repostiroy.CustomerRepository;
import com.example.occasion.Repostiroy.MyServiceRepository;
import com.example.occasion.Repostiroy.ServicetypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
        Customer customer=new Customer(null, dto.getName(), dto.getEmail(), dto.getPassword(), dto.getPhoneNumber(),false,0,null,null);
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


    public Set<Myorder> getMyOrderofCustomer(Integer id) {
        Customer customer = customerRepository.getCustomerById(id);
        if (customer == null) {
            throw new ArithmeticException("Not found");
        }
        return customer.getMyorderSet();
    }

//  public void loyalty(Integer id){
//       Customer customer = customerRepository.getCustomerById(id);
//       if (customer == null)
//            throw new ApiException("Not found");
//        Integer price = customer.getMyorderSet().getServicetypePrice;
//        if (customer.getNumberOfVisit() > 2) {
//            customer.setLoyalty(true);
//            customer.getMyorderSet().setServicetypePeice(price - (price * 20 / 100));
//            customerRepository.save(customer);
//        }
//        else
//            throw new ApiException("Not enough visits");
//    }
}

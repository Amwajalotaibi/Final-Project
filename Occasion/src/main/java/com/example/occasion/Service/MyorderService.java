package com.example.occasion.Service;

import com.example.occasion.ApiException.ApiException;
import com.example.occasion.Model.Customer;
import com.example.occasion.Model.Myorder;
import com.example.occasion.Repostiroy.CustomerRepository;
import com.example.occasion.Repostiroy.MyorderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MyorderService {

    private final MyorderRepository myorderRepository;
    private final CustomerRepository customerRepository;


    public List<Myorder> getAll() {

        return myorderRepository.findAll();
    }


    public void addMyorder(Myorder myorder) {

        myorderRepository.save(myorder);
    }

    public void updateMyorder(Myorder myorder, Integer id) {
        Myorder oldMyorder = myorderRepository.findMyorderById(id);

        if (oldMyorder == null) {
            throw new ApiException("Order not found");
        }

        oldMyorder.setTotalPrice(myorder.getTotalPrice());

        myorderRepository.save(oldMyorder);
    }

    public void deleteMyorder(Integer id) {
        Myorder myorder = myorderRepository.findMyorderById(id);
        if (myorder == null) {
            throw new ApiException("Order not found");
        }

        myorderRepository.delete(myorder);
    }

    public Myorder findMyorderById(Integer id) {
        Myorder myorder = myorderRepository.findMyorderById(id);
        if (myorder == null) {
            throw new ArithmeticException(" Wrong ID ");
        }
        return myorder;
    }

    public List<Myorder> getOrderByDay(Integer day) {
        return myorderRepository.findMyorderByDay(day);

    }

}
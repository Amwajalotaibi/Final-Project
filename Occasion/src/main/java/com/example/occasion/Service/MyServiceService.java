package com.example.occasion.Service;

import com.example.occasion.ApiException.ApiException;
import com.example.occasion.Model.Customer;
import com.example.occasion.Model.MyService;
import com.example.occasion.Repostiroy.MyServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyServiceService {
    private final MyServiceRepository myServiceRepository;

    public List<MyService> getAll(){

        return myServiceRepository.findAll();
    }

    public void addMyService(MyService myService){

        myServiceRepository.save(myService);
    }

    public void updateMyService(Integer id, MyService myService){
        MyService c = myServiceRepository.findMyServiceById(id);
        if (c == null)
            throw new ApiException("Not found");
        c.setName(myService.getName());
        c.setCategory(myService.getCategory());
        myServiceRepository.save(c);
    }

    public void deleteMyService(Integer id){
        MyService c = myServiceRepository.findMyServiceById(id);
        if (c == null)
            throw new ApiException("Not found");
        myServiceRepository.delete(c);
    }


}

package com.example.occasion.Service;

import com.example.occasion.ApiException.ApiException;
import com.example.occasion.DTO.CompanyDTo;
import com.example.occasion.DTO.ServicetypeDto;
import com.example.occasion.Model.Company;
import com.example.occasion.Model.MyService;
import com.example.occasion.Model.MyUser;
import com.example.occasion.Model.Servicetype;
import com.example.occasion.Repostiroy.AuthRepository;
import com.example.occasion.Repostiroy.CompanyRepository;
import com.example.occasion.Repostiroy.MyServiceRepository;
import com.example.occasion.Repostiroy.ServicetypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicetypeService {
    private final ServicetypeRepository servicetypeRepository;
    private final MyServiceRepository myServiceRepository;

    public List<Servicetype>getAll() {
        return servicetypeRepository.findAll();
    }

    public void addservicetype(ServicetypeDto dto) {
        MyService myService = myServiceRepository.findMyServiceById(dto.getServicetype_id());
        if (myService == null) {
            throw new ApiException("sorry can't add");
        }
        Servicetype servicetype = new Servicetype(null, dto.getName(), dto.getDetails(), dto.getPrice(), null);
        servicetypeRepository.save(servicetype);
    }

    public void updateServicetype(ServicetypeDto dTo) {
        MyService myService = myServiceRepository.findMyServiceById(dTo.getServicetype_id());
        if (myService == null) {
            throw new ApiException("MyUser not found");
        }

        Servicetype servicetype = servicetypeRepository.findServicetypeById(dTo.getServicetype_id());
        servicetype.setName(dTo.getName());
        servicetype.setDetails(dTo.getDetails());
        servicetype.setPrice(dTo.getPrice());
        servicetypeRepository.save(servicetype);
    }

    public void deleteServicetype(Integer id){
        Servicetype servicetype=servicetypeRepository.findServicetypeById(id);
        if(servicetype==null)
            throw new ApiException("Company not found");
        servicetypeRepository.delete(servicetype);
    }
}


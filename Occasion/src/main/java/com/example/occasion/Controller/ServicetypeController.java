package com.example.occasion.Controller;

import com.example.occasion.DTO.CustomerDTO;
import com.example.occasion.DTO.RatingDTO;
import com.example.occasion.DTO.ServicetypeDto;
import com.example.occasion.Service.RatingService;
import com.example.occasion.Service.ServicetypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Repository
@RequestMapping("/api/v1/servicetype")
public class ServicetypeController {
    private final ServicetypeService servicetypeService;

    @GetMapping("/get")
    public ResponseEntity getAll(){

        return ResponseEntity.status(200).body(servicetypeService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addCustomerDto(@Valid @RequestBody ServicetypeDto servicetypeDto){
        servicetypeService.addservicetype(servicetypeDto);
        return ResponseEntity.status(200).body("Company added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateservicedto(@Valid @RequestBody ServicetypeDto servicetypeDto){
        servicetypeService.updateServicetype(servicetypeDto);
        return ResponseEntity.status(200).body("Customer Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteaServicetype(@PathVariable Integer id){
        servicetypeService.deleteServicetype(id);
        return ResponseEntity.status(200).body("service-type deleted");
    }

}


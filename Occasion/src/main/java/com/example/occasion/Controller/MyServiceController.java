package com.example.occasion.Controller;

import com.example.occasion.Model.MyService;
import com.example.occasion.Service.MyServiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/myservice")
@RequiredArgsConstructor
public class MyServiceController {

        private final MyServiceService myServiceService;

        @GetMapping("/get")
        public ResponseEntity getAll(){
            return ResponseEntity.status(200).body(myServiceService.getAll());
        }

        @PostMapping("/add")
        public ResponseEntity addMyService(@Valid @RequestBody MyService myService){
            myServiceService.addMyService(myService);
            return ResponseEntity.status(200).body("My Service added");
        }

        @PutMapping("/update/{id}")
        public ResponseEntity updateMyservice(@PathVariable Integer id, @Valid @RequestBody MyService myService){
            myServiceService.updateMyService(id, myService);
            return ResponseEntity.status(200).body("My Service updated");
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteCustomer(@PathVariable Integer id){
            myServiceService.deleteMyService(id);
            return ResponseEntity.status(200).body("My Service deleted");
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
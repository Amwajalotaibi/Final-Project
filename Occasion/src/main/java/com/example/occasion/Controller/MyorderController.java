package com.example.occasion.Controller;

import com.example.occasion.Model.Myorder;
import com.example.occasion.Service.MyorderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/myorder")
@RequiredArgsConstructor
public class MyorderController {
    private final MyorderService myorderService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(myorderService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity addMyorder(@Valid @RequestBody Myorder myorder){
        myorderService.addMyorder(myorder);
        return ResponseEntity.status(200).body("Order added");
    }

    @PutMapping ("/update/{myorderId}")
    public ResponseEntity updateTodo(@RequestBody Myorder  myorder,@PathVariable Integer myorderId){
        myorderService.updateMyorder(myorder,myorderId);
        return ResponseEntity.status(200).body("My Order Update ");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMyorder(@PathVariable Integer id){
        myorderService.deleteMyorder(id);
        return ResponseEntity.status(200).body("Order deleted");

    }










//    @DeleteMapping("/delete/{myorderId}")
//    public ResponseEntity deletemyorder(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer myorderId){
//        myorderService.deleteMyorder(myUser,myorderId);
//
//        return ResponseEntity.status(200).body(" My order delete");
//    }
//
//
//    @GetMapping("/get-id/{id}")
//    public ResponseEntity getMyorderById(@PathVariable Integer id){
//        return ResponseEntity.status(200).body("get My Order By Id"+myorderService.getMyorderById(id));
//    }
//
//    @GetMapping("/chang/{orderId}/{status}")
//    public ResponseEntity changStatus(@AuthenticationPrincipal MyUser  myUser,@PathVariable Integer orderId,@PathVariable String status){
//        myorderService.changeorder(myUser.getId(),orderId,status);
//        return ResponseEntity.status(200).body("Chang Status");
//    }

    //    @PostMapping("/add")
//    public ResponseEntity addMyorder(@AuthenticationPrincipal MyUser myUser, @RequestBody Myorder myorder, @RequestBody Integer productId , @RequestBody Integer userId){
//        myorderService.addMyorder(productId, userId, myorder);
//        return ResponseEntity.status(200).body("My Order Added");
//    }

//    @GetMapping("/get")
//    public ResponseEntity getMyorder(@AuthenticationPrincipal MyUser myUser) {
//        List<Myorder> myorderList=myorderService.getAllMyorder(myUser);
//        return ResponseEntity.status(200).body(myorderList);
//    }
}

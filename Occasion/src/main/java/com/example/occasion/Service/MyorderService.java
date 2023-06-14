package com.example.occasion.Service;

import com.example.occasion.ApiException.ApiException;
import com.example.occasion.Model.Customer;
import com.example.occasion.Model.Myorder;
import com.example.occasion.Repostiroy.AuthRepository;
import com.example.occasion.Repostiroy.CompanyRepository;
import com.example.occasion.Repostiroy.MyorderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MyorderService {

    private final MyorderRepository myorderRepository;


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

    public Myorder getOrderByDay(String day) {
        Myorder myorder = myorderRepository.findMyorderByDay(day);
        if (myorder == null) {
            throw new ArithmeticException("order not found");
        }
        return myorder;
    }

//    public Myorder getOrderByCustomer(Customer customer) {
//        Myorder myorder = myorderRepository.findMyorderByCustomer(new Customer());
//    }
//        if(myorder ==null)
//
//    {
//        throw new ArithmeticException("order not found");
//    }
//         return myorder;

}














    //public void addMyOrder(Integer companyId, Integer userId, Myorder myorder) {

       // MyUser myUser = authRepository.findMyUserById(userId);
      //  Company company = companyRepository.findCompanyById(companyId);
     //   if (myUser == null || company == null) {
           // throw new ApiException("not found");

      //  }
      //  myorder.setTotalPrice(myorder.setTotalPrice());
      //  myorder.setStatus("new");
     //   myorder.setProduct(product);
      //  myorder.setMyUser(myUser);

      //  myorderRepository.save(myorder);


//    public void deleteMyorder(MyUser myUser,Integer id){
//        Myorder A=myorderRepository.findMyorderById(id);
//        if (A == null||  A.getStatus().equals("inprogress"))
//            throw new ApiException("Not found");
//        myorderRepository.delete(A);
//    }
//
//
//    public Myorder getMyorderById(Integer id) {
//        Myorder myorder=myorderRepository.findMyorderById(id);
//        if (myorder == null) {
//            throw new ArithmeticException("ID not found");
//
//        }
//        return myorder;
//    }
//
//  public void changeorder(Integer userId , Integer MyOrderId,String NewStatus){
//       Myorder  myorder=myorderRepository.findMyorderById(MyOrderId);
//        MyUser myUser =authRepository.findMyUserById(userId);
//        if (myorder==null || myUser==null || myUser.getRole().equalsIgnoreCase("customer")){
//            throw new ApiException("not found");
//        }
//        myorder.setStatus(NewStatus);
//        myorderRepository.save(myorder);
//
//    }
//


        //    public void addMyorder(Integer productId, Integer userId, Myorder myorder){
//
//        MyUser myUser =authRepository.findMyUserById(userId);
//        Product product=productRepository.findProductById(productId);
//        if(myUser==null || product==null){
//            throw new ApiException("not found");
//
//        }
//        myorder.setTotalPrice(product.getPrice()*myorder.getQuantity());
//        myorder.setStatus("new");
//        myorder.setProduct(product);
//        myorder.setMyUser(myUser);
//
//        myorderRepository.save(myorder);
//
//    }

//    public List<Myorder> getAllMyorder(MyUser myUser){
//
//        return myorderRepository.findMyorderByMyUser(myUser);
//    }




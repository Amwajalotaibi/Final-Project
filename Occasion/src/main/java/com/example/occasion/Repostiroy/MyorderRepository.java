package com.example.occasion.Repostiroy;

import com.example.occasion.Model.MyUser;
import com.example.occasion.Model.Myorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MyorderRepository extends JpaRepository<Myorder,Integer> {
    Myorder findMyorderById(Integer id);

    List<Myorder> findMyorderByMyUser(MyUser myUser);
}

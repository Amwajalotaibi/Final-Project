package com.example.occasion.Repostiroy;

import com.example.occasion.Model.Servicetype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicetypeRepository extends JpaRepository<Servicetype,Integer> {
    Servicetype findServicetypeById(Integer id);

}

package com.example.occasion.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @NotEmpty(message = "Name is required")
//    @Size(min = 2)
//    @Column(columnDefinition = "varchar(20)")
    private String name;


//    @NotNull(message = "Phone Number is required")
//    @Positive
//    @Column(columnDefinition ="int not null")
    private Integer phoneNumber;


//    @NotEmpty(message = "Email is required")
//    @Email(message = "Invalid Email",regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
//    @Column(columnDefinition = "varchar(40) unique")
    private String email;

    //@NotEmpty(message = "password can't be empty")
//   @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @OneToOne
    @MapsId
    @JsonIgnore
    private MyUser myUser;


    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "customer")
    @JsonIgnore
    private Set<Myorder> myorderSet;



}






//    private boolean loyalty = false;
//
//    private Integer numberOfVisit=0;
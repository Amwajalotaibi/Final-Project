package com.example.occasion.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;


@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "username can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String username;

    @NotEmpty(message = "password can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;


    @NotEmpty(message = "Role can't be empty")
    @Column(columnDefinition = "varchar(20) not null check(role ='licensenumber')")
    private String role;

    @NotEmpty(message = "city can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String city;


    @NotNull
    private Integer Price;

    @OneToOne
    @MapsId
    @JsonIgnore
    private MyUser myUser;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    @JsonIgnore
    private Set<Myorder> myorderSet;


    @ManyToMany
    @JsonIgnore
    @JoinColumn(name = "company_id")
    private Set<MyService> myServiceSet;
 }




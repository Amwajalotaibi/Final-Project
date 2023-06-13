package com.example.occasion.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servicetype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Pattern(regexp = "\\b(?:staff|eat|coordination)\\b",message = "Category Not Valid")
    @Column(columnDefinition = "varchar(20) not null check (name='staff' or name='eat' or name='coordination')")
    private String name;

    @NotEmpty
    @Column(columnDefinition = "varchar(20)not null")
    private String details;

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer price;

    @OneToOne
    @MapsId
    @JsonIgnore
    private MyService myService;
}

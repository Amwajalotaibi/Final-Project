package com.example.occasion.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Myorder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "quantity not null")
    @Column(columnDefinition = "varchar(20) not null check(quantity='bigparty' or quantity='medimparty' or quantity='smallparty')")
    private Integer quantity;

    @NotNull(message = "total price not null")
    @Column(columnDefinition = "int not null")
    private Integer totalPrice;

    @NotEmpty(message = "date can't be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String dateReceived;

    @NotEmpty(message = "Status can't be empty")
    @Column(columnDefinition = "varchar(20) not null check(status ='new' or status='inprogress' or status='completed')")
    private String status;

    @NotEmpty(message = "Service type can't be empty")
    @Column(columnDefinition = "varchar(20) not null check(servicetype ='fullparty' or servicetype='service' )")
    private String servicetype;


}

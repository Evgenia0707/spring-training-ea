package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surName;
    private String userName;
    private String address;
    private String email;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<Payment> paymentList;

    public Customer(String name, String surName, String userName, String address, String email) {
        this.name = name;
        this.surName = surName;
        this.userName = userName;
        this.address = address;
        this.email = email;
    }
}

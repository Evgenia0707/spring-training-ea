package com.cydeo.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Department extends BaseEntity{

    private String department;
    private String division;


}

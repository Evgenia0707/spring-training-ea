package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Data
public class Department {

    @Id
    private String department;//use like primary key (not id)
    private String division;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}

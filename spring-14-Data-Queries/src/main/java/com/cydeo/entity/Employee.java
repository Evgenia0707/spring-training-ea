package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Data
public class Employee extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;

    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer salary;

    @ManyToOne//1 empl can be assign to many depart
    @JoinColumn(name = "department")
    private Department department;

    @ManyToOne//1 empl can be assigned to many region
    @JoinColumn(name = "region_id")
    private Region regionId;

}

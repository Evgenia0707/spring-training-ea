package com.cydeo.dto;

import com.cydeo.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"id"}, ignoreUnknown = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)//in Json response incl only not null - put on all DTO
public class AddressDTO {

    //have all stud, adrr, teach - use @JsonIgnore for fix problem ( backreference or managed reference)
    //managedReference then that is the one we can see
    //put @JsonManagedReference on top of Address field in student, teacher and parent class
    //   @JsonManagedReference inside DTO stud, adrr, teach

    @JsonIgnore
    private Long id;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;

    private AddressType addressType;//in DB entity we use DATA type- EnumType.STRING- in JSon dont need conv String

    @JsonBackReference(value = "student-address-reference")
    //defaultReference - will go for find  @JsonMan //mean put JsonManag in studDto//
    private StudentDTO student;

    @JsonBackReference(value = "parent-address-reference") //defaultReference
    private ParentDTO parent;

    @JsonBackReference(value = "teacher-address-reference")  //defaultReference
    private TeacherDTO teacher;

    private Integer currentTemperature; //weather info, which we will later get it from 3rd party API
    //i dont have in entity - bec change all time -, dont put in DB
    //will be null until consume
    //dont want to see null in Json

}
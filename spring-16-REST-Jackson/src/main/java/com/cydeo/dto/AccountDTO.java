package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"address", "country"}, ignoreUnknown = true)   //can use like this or put on each @JsonIgnore
//anything come to IPA from appl if add somet-q new not going to app ( ignoreUnknown = true )
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {//user have acc - acc have user - problem ( @JsonBackReference)-ex outBond..

    @JsonIgnore
    private String name;

    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;

//    @JsonIgnore//cant sent user info(post)
      @JsonBackReference//This field is not be going to be serialized(not convert json inside acc)//can send user info request(post)
    private UserDTO user;

}

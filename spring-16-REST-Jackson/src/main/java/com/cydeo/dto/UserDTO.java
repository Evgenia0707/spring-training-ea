package com.cydeo.dto;

import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)//cant sent unknown field from dto
public class UserDTO {//user have acc - acc have user - problem ( @JsonManagedReference)

    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)   //(property = name, street,,, fields)
    private String password;//user send passw- but not get from API
    private String username;
    private UserRole role;

    @JsonManagedReference//hide userDto from accDTo //This field is going to be serialized
    private AccountDTO account;
}

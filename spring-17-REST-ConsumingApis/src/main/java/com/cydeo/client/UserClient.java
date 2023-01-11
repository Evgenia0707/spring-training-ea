package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "USER-CLIENT")//url - json place holder(what need consume), (definer)/ key, value
public interface UserClient {
    //https://jsonplaceholder.typicode.com/users" - **


    @GetMapping("/users")
    List<User> getUsers();//when call () - keep endPoint (**) will be execute with GetMapping - Json assign answer to <User> DTO





}

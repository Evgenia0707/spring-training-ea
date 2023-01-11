package com.cydeo.client;

import com.cydeo.dto.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(url="https://dummyapi.io",name = "EMPLOYEE-CLIENT")
public interface EmployeeClient {

    @GetMapping("/data/v1/user?limit=10")
    Employee getEmployee(@RequestHeader("app-id") String id);
    //In request header, the name can be app-id
}


//When we call this method it's returning several employees since we never actually passed the employee id, just the header id. Why isn't an error occurring?
//It is actually returning one object.
//But if you open Employee class, you will see that there is a List<Datum> field.
//If you compare the response in Postman with our Employee class, you will see that the employees in API response actually match with List<Datum> in our Employee class.
//Maybe it might be better to use Employee name for Datum class, and Response name for Employee class.
//But there is no technical issue, only naming issue we have.
//People are using those kind of object names when they can not find a proper name for the object that is coming from API.
//Response,  ResponseDTO or ResponseEntity etc.
//Sometimes similar thing goes for requests too if you are sending request to another API in your application.
//Request,  RequestDTO or RequestEntity etc.


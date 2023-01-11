package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.addressService = addressService;
    }

    //create endPoint

    @GetMapping("/teachers")
    public List<TeacherDTO> readAllTeacher(){//need inject for see all teachers(we use dto - need entity)
        List<TeacherDTO> teachers = teacherService.findAll();//get from teacher service - inject
        return teachers;
    }//was error - did all annotation in DTO - now work

    //create controller for students - create ResponseWrapper inside DTO

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){
        return ResponseEntity.ok(new ResponseWrapper("Students are successfully retrieved", studentService.findAll())); //prov mess + data 1st constr//inj - data will come studentServ
        // ResponseEntity.ok - ode we see in Postman
        // code in body, what we see in Postman  - come from wrapper class
        //if use .ok - can put data directly inside Response body
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents(){ //2nd constr
        ResponseWrapper responseWrapper = new ResponseWrapper(true, "Parents are retrieved successfuly",
                HttpStatus.OK.value(), parentService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(responseWrapper); //need add data by body() - if use status(HttpStatus.OK)
    }

//get address by id

    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> getAddress(@PathVariable("id") Long id) throws Exception {//need use addressService - inject
        AddressDTO addressDTO = addressService.findById(id); //indById(id) thrown exception if addr not find(addreServImpl)
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully retrieved", addressDTO));
    }

    @PutMapping("/address/{id}")
    public AddressDTO updateAddress(@PathVariable("id") Long id, @RequestBody AddressDTO addressDTO) throws Exception {
        addressDTO.setId(id);
        return addressService.update(addressDTO);
    }
    //consume 3rd part API

}

package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")// (concatenation)add class and don't need to put student/

public class StudentController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)// localhost:8080/student/register  ( @RequestMapping("/student/register")

    @GetMapping("/register") //==@RequestMapping(value = "/register", method = RequestMethod.GET)

    public String register(Model model) { //to show html

        model.addAttribute("students", DataGenerator.createStudent());//stud handel data -datagenerator

        return "student/register";//show (retriever page)
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.POST) //localhost:8080/student/welcome?name=Ozzy
//    public String welcome(@RequestParam String name) {
    @PostMapping("/welcome") //equal @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public String welcome() {

//        System.out.println(name);
        System.out.println();

        return "student/welcome";//posting data
    }

//create end point (welcome)
//    @RequestMapping("/welcome")// localhost:8080/student/welcome?id=3  @RequestMapping("/student/drop"
//    public String welcome(@RequestParam int id) {//<!--Adding Parameters in Link-->
//
//        System.out.println(id);
//        return "student/welcome";
//    }

//    name=${student.get(0).firstName} - get student name


}


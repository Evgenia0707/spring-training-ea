package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.IThymeleafBindStatus;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model) {    //Model using carrying data to view
//method Model Interface (pass parameter for execute (), belongs to Model Interface)

        //<h1 th:text="${name}"></h1>
        //                     name attribute holding   Cydeo value
        model.addAttribute("name", "Cydeo");

        //<h1 th:text="${course}"></h1>
        model.addAttribute("course", "MVC");

//convert to thymeleaf tompage
//add in the templates-student-welcome.html ---- <html xmlns:th="http://www.thymeleaf.org"> - hold data now
        return "student/welcome";
    }
    //run - http://localhost:8080/welcome
}

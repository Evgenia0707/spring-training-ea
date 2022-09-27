package com.cydeo.controller;

import com.cydeo.model.Mentor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

//    @RequestMapping("/register") // localhost:8080/mentor/register  ( @RequestMapping("/mentor/register"))

    @GetMapping("/register")       // localhost:8080/mentor/register -end point - wrote in browser - () execute model.add-> go to view have form - need to link to obj - <form th:object="${mentor}">
    public String register(Model model){

        List<String> batchList = Arrays.asList("JD1","JD2", "JD3");
        model.addAttribute("batchList", batchList);      //batchList hold mentor obj

        //attribute mentor  will hold Obj what we filed in web brower
        model.addAttribute("mentor", new Mentor());//create empty obj - give obj to view through attribute"mentor"

//<form th:object="${mentor}"> - html - link to obj
//<input type="text" th:field="*{firstName}"><br> -html -  will be assigned to mentor first name
//when push register - new mentor will be saved in the value

        return "mentor/mentor-register";//view
    }

//     <form th:action="@{/mentor/confirm}"   th:object="${mentor}"> (from mentor-registr) create() and new html



    @PostMapping("/confirm")   //          mentor == attribute mentor
    public String submitForm(@ModelAttribute("mentor") Mentor mentor, Model model ){//catching attr with @ModelAttribute and assign obj to mentor

      //        return "mentor/mentor-register";//to see empty page when confirm + model.addAttribute

        return "redirect:/mentor/register"; //go to method @GetMapping("/register") to end point
    }







//     <form th:action="@{/mentor/confirm}" method="post"  th:object="${mentor}">
    //need defein method
//    @GetMapping("/confirm")
//    public String submitForm2(){
//
//        return "mentor/mentor-confirmation";
//    }


    // in html - <option th:each="theBatch : ${batchList}" th:value="${theBatch}" th:text="theBatch"></option>
    //                         loop -    what was chosen assign to theBatch           for print

//    @RequestMapping("/drop") //localhost:8080/mentor/drop
//    public String drop(){
//
//        return "mentor/register";
//    }
}

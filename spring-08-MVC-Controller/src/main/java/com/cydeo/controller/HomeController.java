package com.cydeo.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {


    @RequestMapping("home")
    public String getHomePage() {  //which en point(login)? www.amazon.com/login
        return "home.html";
    }

    @RequestMapping("ozzy")
    public String getHomePage1() {  //which en point(login)? www.amazon.com/login
        return "home.html";
    }

    @RequestMapping  //nothing and  /
    public String getHomePage2() {  //which en point(login)? www.amazon.com/login
        return "home.html";
    }

    @RequestMapping({"/apple", "/orange"})
    public String getHomePage3() {  //which en point(login)? www.amazon.com/login
        return "home.html";
    }
}

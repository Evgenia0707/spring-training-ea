package com.cydeo.controller;

import com.cydeo.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    @GetMapping("/make")
    public String info(Model model) {


        List<String> infoCar = Arrays.asList("Mercedes", "Audi", "BMW");
        model.addAttribute("infoCar", infoCar);


        model.addAttribute("car", new Car());



        return "car/car-make";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("car") Car car, Model model) {

        return "redirect:/car/make";
    }

}

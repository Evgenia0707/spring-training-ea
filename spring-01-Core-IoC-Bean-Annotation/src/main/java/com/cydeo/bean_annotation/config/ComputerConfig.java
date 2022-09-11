package com.cydeo.bean_annotation.config;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComputerConfig {

    @Bean
    public Monitor monitorSony() {//can create default constr and return empty obj
        return new SonyMonitor("25 inch Beast", "Acer", 25); // Monitor abc = new SonyMonitor (polymorphism)
    }

    @Bean
    public Case caseDell() {
        return new DellCase("220B", "Dell", "240");
    }

    @Bean
    public Motherboard motherboardAsus() {
        return new AsusMotherboard("BJ-200", "Asus", 4, 6, "v2.44");
    }



}
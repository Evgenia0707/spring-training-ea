package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.RandomConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

//Creating container by using Application Context
        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, RandomConfig.class);

//Creating container by using BeanFactory
        BeanFactory context = new AnnotationConfigApplicationContext();

        Monitor theMonitor = container.getBean(Monitor.class);// gave obj what we need and assign
//        SonyMonitor theMonitor = container.getBean(SonyMonitor.class);

        Case theCase = container.getBean(Case.class);
        Motherboard theMotherboard = container.getBean(Motherboard.class);

//get obj from Spring container
        PC myPc = new PC(theCase, theMonitor, theMotherboard);// looking for constructorCase theCase, Monitor monitor, Motherboard motherboard

        myPc.powerUp();
    }

}

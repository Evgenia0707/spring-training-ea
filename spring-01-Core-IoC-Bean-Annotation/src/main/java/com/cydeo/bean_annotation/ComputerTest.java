package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.RandomConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
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

        System.out.println("-----------------Retrieving the beans--------------------------");
        SonyMonitor sony = container.getBean(SonyMonitor.class);
        DellCase dell = container.getBean(DellCase.class);
        AsusMotherboard asus = container.getBean(AsusMotherboard.class);

//get obj from Spring container
        PC myPc = new PC(dell, sony, asus);// looking for constructorCase theCase, Monitor monitor, Motherboard motherboard
        myPc.powerUp();
        dell.pressPowerButton();

        System.out.println("-----------------Retrieving the beans--------------------------");
        Monitor theMonitor = container.getBean(Monitor.class);// gave obj what we need and assign
        Case theCase = container.getBean(Case.class);
        Motherboard theMotherboard = container.getBean(Motherboard.class);

//get obj from Spring container
        PC myPc2 = new PC(theCase, theMonitor, theMotherboard);

        System.out.println("-----------------Multiple Object-------------------------------------");

        Monitor theMonitor2 = container.getBean("monitorSony", Monitor.class);// Default bean Name == Method name
        Monitor theMonitor3 = container.getBean("sony", Monitor.class);// Custom Bean Name == name = "sony"
        Monitor theMonitor4 = container.getBean(Monitor.class);// @Primary  (will give Acer)

        PC myPc3 = new PC(theCase, theMonitor4, theMotherboard);

    }

}

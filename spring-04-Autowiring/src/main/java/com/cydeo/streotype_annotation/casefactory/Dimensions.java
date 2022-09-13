package com.cydeo.streotype_annotation.casefactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
//@AllArgsConstructor
@Component
public class Dimensions { // new Dimensions(int int int) try to inject - no value(not work whit primitive)

    private int width;//Spring try to inject int
    private int height;
    private int depth;

    public Dimensions() {//try to create obj - new dimension - no constructor
        this.width = 10;
        this.height = 30;
        this.depth = 40;
    }

    public void pressPowerButton(){
        System.out.println("Power button press");
    }

}

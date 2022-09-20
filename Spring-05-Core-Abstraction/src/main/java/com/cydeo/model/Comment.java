package com.cydeo.model;

import lombok.Data;

@Data
public class Comment { //never put @Component in Model

//no dependency - no injecting // no injected any class - no has a relationship
//if has a relationship - no
//if need to be injected other class - has a relationship - no

    private String author;
    private String text;

}

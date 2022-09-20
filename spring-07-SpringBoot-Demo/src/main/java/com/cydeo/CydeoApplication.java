package com.cydeo;

import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication//will scan all package - put direct under package
public class CydeoApplication {

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

//will manage automatically - don't need ApplicationContext container =
        ApplicationContext container = SpringApplication.run(CydeoApplication.class, args);

        CommentService commentService = container.getBean(CommentService.class);
        commentService.publishComment(comment);

        System.out.println("___________________________________________________");
        commentService.printConfigData();
        commentService.printDbConfigData();
    }
    //dont need
//        @Bean
//                public String stringBean (){
//            return new String();
//        }

    }



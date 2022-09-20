package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class CommentApp {
    public static void main(String[] args) {

        Comment comment  = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);

//Singleton Bean Scope
        CommentService cs1 = context.getBean(CommentService.class);
        CommentService cs2 = context.getBean(CommentService.class);

        System.out.println("cs1: " +cs1);
        System.out.println("cs2: " +cs2);
        System.out.println(cs1==cs2);//true

//@Scope(BeanDefinition.SCOPE_PROTOTYPE)// create new obj in the container
        CommentService cs3 = context.getBean(CommentService.class);
        CommentService cs4 = context.getBean(CommentService.class);

        System.out.println("cs1: " +cs1);
        System.out.println("cs2: " +cs2);
        System.out.println(cs1==cs2);//false



    }
}

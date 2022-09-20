package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {
        //always put the runner under the base package(cydeo)

        //Spring will create obj in container and manage
        //create container - configuration - all my classes go stereotype annotation

//Ex - create obj from comment - application will do it (from user interface - UI, HTML, or - dataBase)
        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

//create container
        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);


        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);

    }
}

package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {// create loosely - implementation can change //put Interface
//call () belong differ class - bring has a relationship (obj)
//    @Autowired
    private final CommentRepository commentRepository;  //put Interface - implementation will explain
//    @Autowired
    private final CommentNotificationProxy commentNotificationProxy;//final -not initiate - remained to create constructor

//create constructor

//can use  @Qualifier("EMAIL") or @Qualifier("emailCommentNotificationProxy") - default Bean name (always provide this - priority)
    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        //save in the DB
        commentRepository.storeComment(comment);
        //send email
        commentNotificationProxy.sentComment(comment);
    }
}

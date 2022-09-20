package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary// bec we have 2 (pushC..)
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy {//injected CommentService

    @Override
    public void sentComment(Comment comment) {
        System.out.println("Sending notification for comment: " + comment.getText());
    }
}

package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PUSH")
//@Primary// will call as default
public class PushCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sentComment(Comment comment) {
        System.out.println("Sending push notification for comment: " + comment.getText());
    }
}

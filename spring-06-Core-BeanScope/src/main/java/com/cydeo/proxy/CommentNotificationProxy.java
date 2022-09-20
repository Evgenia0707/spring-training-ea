package com.cydeo.proxy;

import com.cydeo.model.Comment;

public interface CommentNotificationProxy {
    void sentComment(Comment comment);
}

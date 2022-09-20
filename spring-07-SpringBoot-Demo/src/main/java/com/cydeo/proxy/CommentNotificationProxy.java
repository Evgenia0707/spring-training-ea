package com.cydeo.proxy;

import com.cydeo.model.Comment;

public interface CommentNotificationProxy {//don't create obj from interface
    void sentComment(Comment comment);
}

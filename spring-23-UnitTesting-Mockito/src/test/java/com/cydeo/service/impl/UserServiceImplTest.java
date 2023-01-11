package com.cydeo.service.impl;

import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)//can use Mockito with my Junit5 Test //using .class - mockito and Junit work properly (tell Junit what quind libary using)
    //mokito intytroduse it lesf to unit - thwy can work togheser
class UserServiceImplTest {

//need to use class not interface

    @Mock //create mock obj // Mock obj instead of UserRepository obj
    UserRepository userRepository;

    @Mock//
    UserMapper userMapper;

    @InjectMocks//only work with class // inject Mock obj - not real
    UserServiceImpl userService;
//    UserServiceImpl userService = new UserServiceImpl(userRepository, userMapper, projectService, taskService);//same

    @Test
    void findByUserName_Test() {//need mock obj  from userRepost and userMapper

        // I'm calling the real method inside the main, which is the method I want to test.
        userService.findByUserName("harold@manager.com");

        // I'm checking if this method ran or not. // works like asserting(verify)
        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);//everethink works until this, not spot run this()

        //verify - check - () ran only 1 time
        verify(userRepository, times(1)).findByUserNameAndIsDeleted("harold@manager.com", false);

        //verify - () ran at list 1 time
        verify(userRepository, atLeastOnce()).findByUserNameAndIsDeleted("harold@manager.com", false);
        verify(userRepository, atLeast(1)).findByUserNameAndIsDeleted("harold@manager.com", false);

        //verify - () ran - can be 0 or 1...
        verify(userRepository, atMostOnce()).findByUserNameAndIsDeleted("harold@manager.com", false);
        verify(userRepository, atMost(10)).findByUserNameAndIsDeleted("harold@manager.com", false);

        //if order correct
        InOrder inOrder = inOrder(userRepository, userMapper);//injection
        // userRepository ran first - userMapper ran second
        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);
        inOrder.verify(userMapper).convertToDto(null);

    }

}

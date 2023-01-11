package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskMapper taskMapper;

    @InjectMocks
    TaskServiceImpl taskService;


    @ParameterizedTest// pass param - will run 3 times( 3 param)
    @ValueSource(longs = {1L, 2L, 3L})
    void findById_Test(long id){
        //behavior, returning obj from mocks

        //Given (Preparation)//creating stubbs
        Task task = new Task();

        when(taskRepository.findById(id)).thenReturn(Optional.of(task));//Optional<Task>
        when(taskMapper.convertToDto(task)).thenReturn(new TaskDTO()); //stub, create on objT Task task = new Task()  (put obj)

        //When (Action is happening)
        taskService.findById(id);//real test //we are not defining this will be () I want to test

        // Then (Assertion and verification checks)
        verify(taskRepository).findById(id);//using stubs in service(), what we running (verify taskService.findById(id))
        verify(taskMapper).convertToDto(task);// verify taskService.findById(id)

        //don't need to get result - need - how many times ran -
    }


    @Test
    void findById_BBD_Test(){//from BBDMOckito - given/when/then

        Task task = new Task();

        //Given
        //same like when(42,43 lines)
        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));//ret optional task
        given(taskMapper.convertToDto(task)).willReturn(new TaskDTO());//ret new

        //When
        taskService.findById(anyLong());

        //Then
        then(taskRepository).should().findById(anyLong());//should run this ()
        then(taskMapper).should(atLeastOnce()).convertToDto(task);//should at list 1 convert
    }








}
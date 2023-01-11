package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;
    @Mock
    ProjectMapper projectMapper;
    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_Test() {
        //my test need to do this (return new entity - dummy)
        //when my () ran (if see any String) . return new entity

        // Given (how should behave)  -- preparation on the test -- //when () cald return simple data - new Project
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project()); // Stubbing (behaviors)
        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO());//(any project Dto)

        // When -- execution on the real () --  (real action - call () what want to test)
        ProjectDTO projectDTO = projectService.getByProjectCode(anyString());//if returning obj null or not

        // Then -- Verification and assertion-- (all verification and assertion)
        InOrder inOrder = inOrder(projectRepository, projectMapper);  // I want to check the order of these 2 Mocks

        // We are providing in which order these 2 Mocks should be
        inOrder.verify(projectRepository).findByProjectCode(anyString());
        inOrder.verify(projectMapper).convertToDto(any(Project.class));

        assertNotNull(projectDTO);//checking res  value null or not

    }

    @Test
    void getByProjectCode_ExceptionTest() {
        //if see empty string in return , throw exception //define behavior
        when(projectRepository.findByProjectCode("")).thenThrow(new NoSuchElementException("Project Not Found"));
        //  running code                           exception type (is correct)        testing ()  --need use lambda
        Throwable throwable = assertThrows(NoSuchElementException.class, () -> projectService.getByProjectCode(""));
        //() with empty string running in app (verif if run)
        verify(projectRepository).findByProjectCode("");
        //      convertor ran or not  (exception thrown in correct place)
        verify(projectMapper, never()).convertToDto(any(Project.class));
        //    for exception message             , real exception   (it is correct exception)
        assertEquals("Project Not Found", throwable.getMessage());//check values
    }




}
package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {


    private final CourseService courseService;


    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping//GET  localhost:8080/courses/api/v3
    public ResponseEntity<ResponseWrapper> getAllCourses(){//ResponseWrapper - custom class
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version", "Cydeo.V3")
                .body(new ResponseWrapper("courses successfully retrieved", courseService.getCourses()) );
        // won see ResponseWrapper,(obj - new (create), body-cousreSer)
    }
    @GetMapping("{id}")// GET  localhost:8080/courses/api/v3/2
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") long courseId){
        return ResponseEntity
                .ok(new ResponseWrapper("course: " + courseId + " retrieved", courseService.getCourseById(courseId)));  //don't change status
    }






}

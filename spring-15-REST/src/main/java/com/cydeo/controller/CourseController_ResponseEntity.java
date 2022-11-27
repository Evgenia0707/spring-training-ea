package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
public class CourseController_ResponseEntity {

    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }
//create API point - Header
    @GetMapping//localhost:8080/courses/api/v2 GET
    public ResponseEntity<List<CourseDTO>> getAllCourses(){//ResponseEntity<T>//can past Headers, modify output
        return  ResponseEntity  //ret type ResponseEntity - obj, List<CourseDTO
                .status(HttpStatus.ACCEPTED)//change status to 202
                .header("Version", "cydeo.V2")//header (t , value)
                .header("Operation", "Get List")
                .body(courseService.getCourses());//T body - what give to API
    }

    @GetMapping("{id}")//localhost:8080/courses/api/v2/1
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") long courseId){
        return ResponseEntity.ok(courseService.getCourseById(courseId));//T body - ok = same status 200 - body-what coming from service
    }

    @GetMapping("category/{name}")//pass name //localhost:8080/courses/api/v2/category/Spring
    public ResponseEntity<List<CourseDTO>> getCourseByCategory(@PathVariable("name") String category) {//catch name @PathVariable("name")
        return ResponseEntity.ok(courseService.getCoursesByCategory(category));
    }

    @PostMapping//POST //localhost:8080/courses/api/v2/
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course){//catch from body (obj)
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation", "Create")//Status: 201 Created
                .body(courseService.createCourse(course));
    }



}

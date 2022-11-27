package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import jdk.jfr.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // = @Controller//dispatcher server look for it + @ResponseBody //not working with view - API
@RequestMapping("/courses/api/v1")//v1 - version - can change
public class CourseController {

//API endPoints
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping// localhost:8080/courses
    public List<CourseDTO> getAllCourses() {

//return all courses//do I have a service//yes - injection
        return courseService.getCourses();//back to method
    }

    @GetMapping("{id}")//localhost:8080/courses/2 --- id - primary key
    public CourseDTO getCourseById(@PathVariable("id") long courseId) {
        return courseService.getCourseById(courseId);//come from HTTp - PathVar - courseId
    }

    @GetMapping("category/{name}")//localhost:8080/courses/category/Spring
    public List<CourseDTO> getCourseByCategory(@PathVariable("name") String category) {//catch id from app
        return courseService.getCoursesByCategory(category);
    }

//create course - go postman - body
//need capture @RequestBody for capture update obj - what put ib body in postmen - capture
    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course) {//catch Json obj
        return courseService.createCourse(course);
    }

//update obj
    @PutMapping("{id}")//which obj update
    public void updateCourse(@PathVariable("id") long courseId, @RequestBody CourseDTO course) {//@RequestBody - for capture update obj- go DB update by id
        courseService.updateCourse(courseId, course); //what update , for what
    }

    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable("id") long courseId) {
        courseService.deleteCourseById(courseId);
    }


}

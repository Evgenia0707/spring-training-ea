package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository <Course, Long>{
    //write methods what Jpa repository don't give to me
    //work only with courses - not empl...

    //find all courses by category  SELECT * FROM COURSES WHERE CATEGORY IS .....
    //find, read, get - return type =List-<many courses>
    List<Course> findByCategory(String category);

    //find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //checks if a course with the supplied name exists. Return true if exists, false otherwise
    boolean existsByName(String name);

    //returns the count of courses for the given category
    int countByCategory(String category);

    //find all the courses that start with the given course name string
    List<Course> findByNameStartingWith(String name);

    //find all courses by category and return a stream
    Stream<Course> streamAllByCategory(String category);

    //named param
        @Query("SELECT c FROM Course c WHERE c.category = : category AND c.rating > : rating")
    List<Course> retrieveAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);
        //Param (must match with category) assign - to str category


}

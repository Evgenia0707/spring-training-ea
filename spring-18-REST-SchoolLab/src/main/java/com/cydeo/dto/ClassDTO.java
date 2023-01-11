
package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)//in Json response incl only  not null

public class ClassDTO {

    @JsonIgnore
    private Long id;//id is an auto increment field, if i give you 20 as an id, you can search 21 and get different person's detail
    //in work environment you should share uuid instead of id. it is not predictable

    private String name;
    private Integer year;

    private CourseDTO course;

    private TeacherDTO teacher;

}
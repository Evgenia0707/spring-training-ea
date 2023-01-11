package com.cydeo.controller;
import com.cydeo.dto.StudentDTO;
import com.cydeo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)//test controller
public class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean // want to test only studContr  //@Mock - with obj directly, test () in serv, ent
    StudentService studentService;

    @Test
    void getStudent_Test() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/student")//create request
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) //MockMvcResultMatchers.*// check result
                .andExpect(content().json("{\"firstName\": \"Mike\", \"lastName\":  \"Smith\", \"age\": 20}"))
                .andDo(print())// for see info when pass test (when test fall - will see info withiut andDo)//print - req and response
                .andReturn();

    }

    @Test
    void jsonAssert_Test() throws Exception {

        String expected = "{\"firstName\": \"Mike\", \"lastName\":  \"Smith\", \"age\": 20}";//true
//        String expected = "{\"firstName\": \"Mike\", \"lastName\":  \"Smith\"}";//false

        String actual = mvc.perform(MockMvcRequestBuilders.get("/student")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString(); //return mvc result by default // need convert mvc to string

        // expected -> {"firstName": "Mike", "lastName":  "Smith", "age": 20}
        //actual -> {"firstName": "Mike", "lastName":  "Smith", "age": 20}

        //not prefer way
        JSONAssert.assertEquals(expected, actual,true); //for exact matching  //starter test depend have  JSONAssert
//        JSONAssert.assertEquals(expected, actual,false);   //don't care about full info

        /*
         @GetMapping("/student")
    public StudentDTO getStudent() {
        return new StudentDTO("Mike", "Smith", 20);
         */

    }
//Unit Testing
    @Test
    void getStudents_Test() throws Exception{

        when(studentService.getStudents()).thenReturn(Arrays.asList(    //when see (), dont run() for real - just return
            new StudentDTO("John", "Doe", 20),
            new StudentDTO("Tom", "Hanks", 50)
        )); // Creating my stub (behavior for my mock obj/StudentService obj)

//test controller

        mvc.perform(MockMvcRequestBuilders.get("/students")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content()
                        .json("[{\"firstName\": \"John\", \"lastName\":  \"Doe\", \"age\": 20}" +
                                ", {\"firstName\": \"Tom\", \"lastName\":  \"Hanks\", \"age\": 50}]"))
                .andDo(print())
                .andReturn();
        }
    /*
 @GetMapping("/students")
    public List<StudentDTO> getStudents() {
        return studentService.getStudents();
 */


}
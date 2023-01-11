package com.cydeo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;//change for all
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;//change for all

@WebMvcTest(WelcomeController.class)//put what test (need bean on this class)// test controller
public class WelcomeControllerTest {


    @Autowired//not use constr inj
    private MockMvc mvc;//inj mockMvc to welcomeContr class

    //request    test
    @Test
    void welcome_Test() throws Exception {
        //call  /welcome endpoint
        // verify response is "welcome"
//create request
        RequestBuilder request = MockMvcRequestBuilders.get("/welcome")//get = HTTP() send get(or other) request to endPoint
                .accept(MediaType.APPLICATION_JSON);  //header (accept in Json format)

//send req - use MvcLayer (MockMvc mvc)  - perform - send req
        MvcResult result = mvc.perform(request).andReturn();//what response - result

// verify response is "welcome"// check result - correct or not
        assertEquals(200, result.getResponse().getStatus());//expected code, actual
        assertEquals("welcome", result.getResponse().getContentAsString());//verify content - welcome
    }//                                                       conv to string and give it to me
//Second Way - easier to use

    @Test
    void welcome_Test2() throws Exception {//create req
        RequestBuilder request = MockMvcRequestBuilders.get("/welcome")//get = HTTP() send get req to endPoint
                .accept(MediaType.APPLICATION_JSON);  //header

        mvc.perform(request)//send req
                .andExpect(status().isOk())  // check if result what I expect
                .andExpect(content().string("welcome"))//content - response body(can convert to obj , we need str)
                .andReturn();
    }






}

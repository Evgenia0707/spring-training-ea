package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jdk.jfr.ContentType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User", description = "User CRUD Operations")//can have 1 response or multiple
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//like in =  https://app.swaggerhub.com/apis/4030071_1/open-api-training/1.0#/Course/get_v1_courses_list

    @GetMapping("/list")
    @Operation(summary = "Read all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved users (OK)",
            content = @Content(mediaType = "application/json")),//change content
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),  // send with no body
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    })  //change in which format send info//list of api responses
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    //json - doing serialization and ...( json working with json format)
    //we can use json for s and .. for xml format too


    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},//want to send with json and xml
         produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})//convert DTO to both (Json and xml)

//    @PostMapping
    @Operation(summary = "Creat a user")
    @ApiResponse(responseCode = "201", description = "User Created successfully (CREATED)",//send back only 1 ipa response, create success
    content = {@Content(mediaType = "application/xml"), @Content(mediaType = "application/json")},//multiple responses//use content annotation (send xml response)
    headers = {@Header(name = "Connection", description = "keep-alive")})//resp should incl connection...

    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userDTO));
    }

}

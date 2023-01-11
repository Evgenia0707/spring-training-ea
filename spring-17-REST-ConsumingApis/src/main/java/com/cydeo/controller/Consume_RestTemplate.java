package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/cydeo")//create endPoint
public class Consume_RestTemplate {

    //consume API by using restTemplate (3 party)

    private final String URI = "https://jsonplaceholder.typicode.com/users";//info store in this API
    //we send request - return info we put in request(not original info)
    //URI what we want to hit

    private final RestTemplate restTemplate;//coming with Spr framework - we create Bean for use ()

    public Consume_RestTemplate(RestTemplate restTemplate) {//get output - show dto
        this.restTemplate = restTemplate;
    }
    //create API endPoint
//can manipulate with dto - can say @JsonIgnore and don't see it (we use 3 part - don't need in our dto)
    @GetMapping//localhost:8080/cydeo
    public ResponseEntity<User[]> readAllUsers() {

        return restTemplate.getForEntity(URI, User[].class); //string(UIR what consume), class(which DTO want convert) entity way how accept param ->[]
        //data consume from other part
        //restTemplate.getForEntity(URI, User[].class) give uri and show dto what have - i will get......
        // - return ResponseEntity (Entity)
    }


    @GetMapping("{id}")//dont have dto , can implement all objects //localhost:8080/cydeo/2
    public Object readUser(@PathVariable("id") Integer id) {

        String URL = URI + "/{id}";//base on id show sertan user// go to db - hit - return

        return restTemplate.getForObject(URL, Object.class, id);  //consume and return//
    }

    //need password  /in case, if api has security and is requesting app id: "error": "APP_ID_MISSING"

    @GetMapping("/test")//localhost:8080/cydeo/test  //https://dummyapi.io/data/v1/user?limit=10 - consume API
    public ResponseEntity<Object> consumePostFromDummyApi(){

        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));//set headers//want info come to me in Json
        headers.set("app-id","6298ebfecd0551211fce37a6");//public api ask use api this they own structure//need out this info in the header

        HttpEntity<String> entity = new HttpEntity<>(headers);//past entity - send header - send inside restTemplate https://dummyapi.io/data/v1/user?limit=10

        //after consume Api
//create headers - exchange (url, what () execute, header, object)
        return restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET, entity, Object.class); // past headers

    }


}

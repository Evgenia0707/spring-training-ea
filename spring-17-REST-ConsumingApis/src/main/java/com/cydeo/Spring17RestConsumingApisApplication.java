package com.cydeo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients//for Feign Client for consume(bec Spring Cloud)
public class Spring17RestConsumingApisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring17RestConsumingApisApplication.class, args);
    }

    @Bean//want use () belong to this class in differ classes (need bean)
    public RestTemplate restTemplate() {// not coming from Spring Cloud
        return new RestTemplate();
    }


    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
//can be DTO - assign what have inside

//https://www.jsonschema2pojo.org/ - for create DTO


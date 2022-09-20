package com.cydeo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Data
@Configuration
public class AppConfigData {
    //values from application.properties

    @Value("${my_username}")
    private String my_userName;

    @Value("${my_password}")
    private String my_password;

    @Value("${my_url}")
    private String my_url;

}

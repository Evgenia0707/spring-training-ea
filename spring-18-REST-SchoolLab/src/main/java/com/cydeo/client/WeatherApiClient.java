package com.cydeo.client;

import com.cydeo.dto.WeatherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://api.weatherstack.com", name = "WEATHER-CLIENT")
//http://api.weatherstack.com   /current?access_key=02a009b8e3922c395677a1e85406aca6&query=London
public interface WeatherApiClient {
    //impl will do feigh client auto

    //which ipa end point need to hit
    @GetMapping("/current")
    WeatherDTO getCurrentWeather(@RequestParam(value = "access_key") String key,
                                 @RequestParam(value = "query") String city);//need send param to app
    //take them from documentation to hum send request
    //http://api.weatherstack.com/current
    //    ? access_key = YOUR_ACCESS_KEY
    //    & query = New York



}

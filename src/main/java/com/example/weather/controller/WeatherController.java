package com.example.weather.controller;

import com.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public Mono<String> getWeather(@RequestParam String city, @RequestParam String apiKey) {
        return weatherService.getWeather(city, apiKey);
    }
}
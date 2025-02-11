package com.example.weather.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    private final WebClient webClient;

    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openweathermap.org/data/2.5").build();
    }

    public Mono<String> getWeather(String city, String apiKey) {
        return this.webClient.get()
                .uri("/weather?q={city}&units=metric&appid={apiKey}", city, apiKey)
                .retrieve()
                .bodyToMono(String.class);
    }
    
}

package com.weather.demo.controller;

import com.weather.demo.model.WeatherResponse;
import com.weather.demo.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherController {

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping("/getWeatherByCity")
    public ResponseEntity<WeatherResponse> getWeatherByCity(@RequestParam("city") String city, @RequestParam("country") String country){
        WeatherResponse weatherResponse = weatherService.getWeatherInfoForCity(city, country);
        return ResponseEntity.ok(weatherResponse);
    }

    @GetMapping("/getWeatherByCoordinates")
    public ResponseEntity<WeatherResponse> getWeatherByCoordinates(@RequestParam("lon") String lon, @RequestParam("lat") String lat){
        WeatherResponse weatherResponse = weatherService.getWeatherInfoForCoordinates(lon, lat);
        return ResponseEntity.ok(weatherResponse);
    }

}

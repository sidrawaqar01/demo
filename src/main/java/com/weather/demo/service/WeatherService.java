package com.weather.demo.service;

import com.weather.demo.model.WeatherResponse;
import com.weather.demo.network.HttpClient;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private HttpClient httpClient;

    public WeatherService(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    public WeatherResponse getWeatherInfoForCity(String city, String country){
        return httpClient.getWeatherByCity(city+","+country);
    }

    public WeatherResponse getWeatherInfoForCoordinates(String lon, String lat){
        return httpClient.getWeatherForCoordinates(lon, lat);
    }
}

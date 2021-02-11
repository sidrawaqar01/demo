package com.weather.demo.network;

import static java.lang.String.format;

import com.weather.demo.model.WeatherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClient {

    private RestTemplate restTemplate;

    public HttpClient(){
        restTemplate = new RestTemplate();
    }

    public WeatherResponse getWeatherByCity(String city){
        String url = format(Contants.GET_WEATHER_BY_CITY, city, Contants.APP_ID);
        ResponseEntity<WeatherResponse> weatherResponse =  restTemplate.getForEntity(url, WeatherResponse.class);
        if(!weatherResponse.getStatusCode().is2xxSuccessful()){
            throw new RuntimeException("Exception while processing. " + weatherResponse.getStatusCode());
        }
        return weatherResponse.getBody();
    }

    public WeatherResponse getWeatherForCoordinates(String lon, String lat){
        String url = format(Contants.GET_WEATHER_BY_LONG_LAT, lon, lat, Contants.APP_ID);
        ResponseEntity<WeatherResponse> weatherResponse =  restTemplate.getForEntity(url, WeatherResponse.class);
        if(!weatherResponse.getStatusCode().is2xxSuccessful()){
            throw new RuntimeException("Exception while processing. " + weatherResponse.getStatusCode());
        }
        return weatherResponse.getBody();
    }
}

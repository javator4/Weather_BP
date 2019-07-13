package pl.sda;

import pl.sda.weather.Condition;
import pl.sda.weather.Current;
import pl.sda.weather.Location;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Scanner;

public class WeatherService {

    private String weather_url;
    private String key;
    private String city;
    private Current current;
    private Condition condition;
    private Location location;

    public WeatherService(String url, String key) {

        weather_url = url + key + "&q=";
        this.key = key;
    }

    public Current getCityWeather(String city) {

        this.city = city;
        weather_url = weather_url + city;

        createWeatherObj();
        return current;
    }

    private void createWeatherObj() {
        
    }
}

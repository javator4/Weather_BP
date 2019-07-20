package pl.sda;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.model.Weather;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FasterImplementation extends JSONDataFaster {

    private String city;

    public FasterImplementation(String url, String key, String city) {
        super(url, key);
        this.city = city;
    }
}
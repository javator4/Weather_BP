package pl.sda;

import org.json.JSONException;
import org.json.JSONObject;
import pl.sda.model.Current;
import pl.sda.model.Location;
import pl.sda.model.Weather;

public class OrgImplementation implements WeatherForecast{

    private JSONDataFaster weatherService;
    private String city;

    public OrgImplementation(JSONDataFaster weatherService, String city) {
        this.weatherService = weatherService;
        this.city = city;
    }

    @Override
    public Weather getWeather() {
        String temp, lat, lon, country, name;
        temp = lat = lon = country = name = "";
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(this.weatherService.getJSONData(this.city));


         temp = jsonObject.getJSONObject("current")
                .get("temp_c").toString();
         lat = jsonObject.getJSONObject("location").get("lat").toString();
         lon = jsonObject.getJSONObject("location").get("lon").toString();
         country = jsonObject.getJSONObject("location").get("country").toString();
         name = jsonObject.getJSONObject("location").get("name").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Weather weather = new Weather();

        Current current =  Current.builder()
                .temperature(Float.parseFloat(temp))
                .build();

        Location location =  Location.builder()
                .lat(Float.parseFloat(lat))
                .lon(Float.parseFloat(lon))
                .country(country)
                .name(name)
                .build();

        weather.setCurrent(current);
        weather.setLocation(location);

        return weather;
    }
}
package pl.sda;

import org.apache.log4j.Logger;
import pl.sda.model.Weather;

public class App {

    private static Logger logger = Logger.getLogger(App.class);

    public static void main( String[] args ) {
        logger.info("URUCHOMEINIE APLIKACJI");
        logger.warn("WARNING");
        logger.debug("DEBUG");
        logger.error("ERROR");

        JSONDataFaster weatherService = new JSONDataFaster(
                "http://api.weatherstack.com/current",
                "0"
        );

        JSONDataOrg weatherService1 = new JSONDataOrg(
                "http://api.weatherstack.com/current",
                "0"
        );

        weatherService.getJSONData("torun");

        Weather weather = weatherService.getWeather();
        Weather weather1 = weatherService1.getWeather();

        //System.out.println(weather.toString());
        System.out.println(weather1.toString());
    }
}

package pl.sda;

import org.apache.log4j.Logger;
import pl.sda.model.Weather;

public class App
{

    private static Logger logger = Logger.getLogger(App.class);

    public static void main( String[] args ) {
        logger.info("URUCHOMEINIE APLIKACJI");
        logger.warn("WARNING");
        logger.debug("DEBUG");
        logger.error("ERROR");

        String url =
                "http://api.apixu.com/v1/current.json" +
                        "?key=e62328dd3789489597281354191307&q=Paris";

        JSONDataFaster weatherService = new JSONDataFaster(
                "http://api.apixu.com/v1/current.json",
                "e62328dd3789489597281354191307"
        );

        weatherService.getJSONData("torun");

        Weather weather = weatherService.getWeather();
    }
}

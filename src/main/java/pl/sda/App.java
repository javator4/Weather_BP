package pl.sda;

import org.apache.log4j.Logger;
import pl.sda.model.Weather;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Scanner;

public class App {

    private static Logger logger = Logger.getLogger(App.class);

    public static void main( String[] args ) throws FileNotFoundException {
        logger.info("URUCHOMEINIE APLIKACJI");
        logger.warn("WARNING");
        logger.debug("DEBUG");
        logger.error("ERROR");

        String key = "";
                File f = new File("key.txt");
        Scanner sr = new Scanner(f);
        if(sr.hasNextLine()) key = sr.nextLine();
        JSONDataFaster weatherService = new JSONDataFaster(
                "http://api.weatherstack.com/current",
                key
        );

        JSONDataOrg weatherService1 = new JSONDataOrg(
                "http://api.weatherstack.com/current",
                key
        );

        weatherService.getJSONData("torun");

        Weather weather = weatherService.getWeather();
        Weather weather1 = weatherService1.getWeather();

        System.out.println(weather.toString());
        System.out.println(weather1.toString());
    }
}

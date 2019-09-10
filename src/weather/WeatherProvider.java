package weather;

import simulator.Aircrafts.Coordinates;

import java.util.*;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather = {"RAIN", "SUN", "FOG", "SNOW"};

    private WeatherProvider(){}

    public static WeatherProvider getProvider() { return WeatherProvider.weatherProvider; }

    public String getCurrentWeather(Coordinates coordinates){
        Random rand = new Random();
        int current = rand.nextInt(4);
        return weather[current];
    }
}

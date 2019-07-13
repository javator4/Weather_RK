package pl.sda;

import pl.sda.model.Current;
import pl.sda.model.WeatherService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String city = "Torun";
       //http://api.apixu.com/v1/current.json?key=6dfd28dca0f6486e86581449191307&q=Torun
        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json",
                "6dfd28dca0f6486e86581449191307");

        Current current = weatherService.getCityWeather(city);

        System.out.println("Temp w miescie " + city + ": " + current.getTemp_c() + "C");

        System.out.println( "Hello World!" );

    }
}

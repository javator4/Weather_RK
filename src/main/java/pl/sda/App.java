package pl.sda;

import org.apache.log4j.Logger;

public class App {

    private static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("URUCHOMIENIE APLIAKCJI");
//        logger.warn("WARNING");
//        logger.debug("DEBUG");
//        logger.error("ERROR");


        String url = "http://api.apixu.com/v1/current.json?key=6dfd28dca0f6486e86581449191307&q=Torun";
        String city = "Torun";
        //http://api.apixu.com/v1/current.json?key=6dfd28dca0f6486e86581449191307&q=Torun
        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json",
                "6dfd28dca0f6486e86581449191307");

//        Current current = weatherService.getJSONData(city).getCityWeather();
//        System.out.println("Temp w miescie " + city + ": " + current.getTemp_c() + "C");
//
//        Location location = weatherService.getJSONData(city).getLocation();
//
//        System.out.println(location.getLat());
//        System.out.println(location.getLon());
//
//        Weather weather = weatherService.getJSONData(city).getWeather();
//
//        System.out.println(weather.getLocation().getCountry());
//
//        System.out.println("Wiatr w " + city + ": " + weather.getCurrent().getWind_mph());

        WeatherForecast weatherForecast = new OrgImplementation(weatherService, "Torun");
        WeatherForecast weatherForecast1 = new FasterImplementation(weatherService, "Torun");

        System.out.println(weatherForecast.getWeather().getLocation().getTz_id());
        System.out.println(weatherForecast.getWeather().getCurrent().getWind_kph());
        System.out.println(weatherForecast1.getWeather().getLocation().getTz_id());
        System.out.println(weatherForecast1.getWeather().getCurrent().getWind_kph());

        JsonDataFaster jsonDataFaster = new JsonDataFaster();
        jsonDataFaster.setUrl("http://api.apixu.com/v1/current.json");
        jsonDataFaster.setApiKey("6dfd28dca0f6486e86581449191307");
        jsonDataFaster.setCity(city);
        jsonDataFaster.build();
        System.out.println(jsonDataFaster.getWeather().getLocation().getTz_id());
        System.out.println(jsonDataFaster.getWeather().getCurrent().getWind_kph());


        JsonDataOrg jsonDataOrg = new JsonDataOrg();
        jsonDataOrg.setUrl("http://api.apixu.com/v1/current.json");
        jsonDataOrg.setApiKey("6dfd28dca0f6486e86581449191307");
        jsonDataOrg.setCity(city);
        jsonDataOrg.build();

        System.out.println(jsonDataOrg.getWeather().getLocation().getTz_id());
        System.out.println(jsonDataOrg.getWeather().getCurrent().getWind_kph());


    }
}

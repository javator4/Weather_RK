package pl.sda;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.model.Weather;

import java.io.File;

public class FasterImplementation implements WeatherForecast {

    private WeatherService weatherService;
    private String city;

    public FasterImplementation(WeatherService weatherService, String city) {
        this.weatherService = weatherService;
        this.city = city;

    }

    @Override
    public Weather getWeather() {

        ObjectMapper objectMapper = new ObjectMapper();
        Weather weather = null;

        try {
            weather = objectMapper.readValue(this.weatherService.getJSONData(this.city), Weather.class);
            objectMapper.writeValue(new File("data.json"), weather);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weather;
    }


}

package pl.sda;

import org.json.JSONObject;
import pl.sda.model.Current;
import pl.sda.model.Location;
import pl.sda.model.Weather;

public class OrgImplementation implements WeatherForecast{

    private WeatherService weatherService;
    private String city;

    public OrgImplementation(WeatherService weatherService, String city) {
        this.weatherService = weatherService;
        this.city = city;

    }

    @Override
    public Weather getWeather() {

        JSONObject jsonObject = new JSONObject(this.weatherService.getJSONData(this.city));
        String lat = jsonObject.getJSONObject("location").get("lat").toString();


        Location location = Location.builder()
                .lat(Float.parseFloat(lat))
                .lon(Float.parseFloat(jsonObject.getJSONObject("location").get("lon").toString()))
                .country(jsonObject.getJSONObject("location").get("country").toString())
                .tz_id(jsonObject.getJSONObject("location").get("tz_id").toString())
                .build();

        Current current = Current.builder()
                .temp_c(Float.parseFloat(jsonObject.getJSONObject("current").get("temp_c").toString()))
                .is_day(Integer.parseInt(jsonObject.getJSONObject("current").get("is_day").toString()))
                .wind_kph(Double.parseDouble(jsonObject.getJSONObject("current").get("wind_kph").toString()))
                .pressure_mb(Double.parseDouble(jsonObject.getJSONObject("current").get("pressure_mb").toString()))
                .cloud(Integer.parseInt(jsonObject.getJSONObject("current").get("cloud").toString()))
                .build();

        Weather weather = new Weather();

        weather.setCurrent(current);
        weather.setLocation(location);

        return weather;

    }


}

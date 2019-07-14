package pl.sda;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import pl.sda.model.Current;
import pl.sda.model.Location;
import pl.sda.model.Weather;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {

    private String url;
    private String apiKey;
    private String finalURL;
    private String data = "";


    public WeatherService(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
        this.finalURL = this.url + "?key=" + apiKey + "&q=";

        //http://api.apixu.com/v1/current.json?key=6dfd28dca0f6486e86581449191307&q=Torun
    }

    public String getJSONData(String city) {

        if (data.isEmpty()) {

            finalURL = finalURL + city;

            try {
                this.data = IOUtils.toString(new URL(this.finalURL), Charset.forName("UTF-8"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;

    }



    public Location getLocation() {
        JSONObject jsonObject = new JSONObject(data);

        Location location = Location.builder()
                .lat(Float.parseFloat(jsonObject.getJSONObject("location").get("lat").toString()))
                .lon(Float.parseFloat(jsonObject.getJSONObject("location").get("lon").toString()))
                .build();

        return location;
    }

    public Current getCityWeather() {


        JSONObject jsonObject = new JSONObject(data);

//            String temp = jsonObject.getJSONObject("current").get("temp_c").toString();
//            System.out.println(temp);

        Current current = Current.builder()
                .temp_c(Float.parseFloat(jsonObject.getJSONObject("current").get("temp_c").toString()))
                .is_day(Integer.parseInt(jsonObject.getJSONObject("current").get("is_day").toString()))
                .wind_kph(Float.parseFloat(jsonObject.getJSONObject("current").get("wind_kph").toString()))
                .pressure_mb(Double.parseDouble(jsonObject.getJSONObject("current").get("pressure_mb").toString()))
                .cloud(Integer.parseInt(jsonObject.getJSONObject("current").get("cloud").toString()))
                .build();

//            current.setTemp_c(Float.parseFloat(jsonObject.getJSONObject("current").get("temp_c").toString()));
//            current.setIs_day(Integer.parseInt(jsonObject.getJSONObject("current").get("is_day").toString()));
//            current.setWind_kph(Float.parseFloat(jsonObject.getJSONObject("current").get("wind_kph").toString()));
//            current.setPressure_mb(Double.parseDouble(jsonObject.getJSONObject("current").get("pressure_mb").toString()));
//            current.setCloud(Integer.parseInt(jsonObject.getJSONObject("current").get("cloud").toString()));

        return current;


    }

}

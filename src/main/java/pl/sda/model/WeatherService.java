package pl.sda.model;

import netscape.javascript.JSObject;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {

    private String url;
    private String apiKey;
    private String finalURL;


    public WeatherService(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
        this.finalURL = this.url + "?key=" + apiKey + "&q=";

        //http://api.apixu.com/v1/current.json?key=6dfd28dca0f6486e86581449191307&q=Torun
    }

    public Current getCityWeather(String city) {

        finalURL = finalURL + city;

        try {
            String data = IOUtils.toString(new URL(this.finalURL), Charset.forName("UTF-8"));
            //System.out.println(data);
            JSONObject jsonObject = new JSONObject(data);

//            String temp = jsonObject.getJSONObject("current").get("temp_c").toString();
//            System.out.println(temp);

            Current current = new Current();
            current.setTemp_c(Float.parseFloat(jsonObject.getJSONObject("current").get("temp_c").toString()));
            current.setIs_day(Integer.parseInt(jsonObject.getJSONObject("current").get("is_day").toString()));
            current.setWind_kph(Float.parseFloat(jsonObject.getJSONObject("current").get("wind_kph").toString()));
            current.setPressure_mb(Double.parseDouble(jsonObject.getJSONObject("current").get("pressure_mb").toString()));
            current.setCloud(Integer.parseInt(jsonObject.getJSONObject("current").get("cloud").toString()));

            return current;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}

package pl.sda;

import org.apache.commons.io.IOUtils;
import pl.sda.model.Weather;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public abstract class AbstractJsonData {

    private String url;
    private String apiKey;
    private String finalURL;
    private String data = "";


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
    
    abstract Weather getWeather();




}

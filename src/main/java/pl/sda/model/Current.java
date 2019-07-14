package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Current {

    private int last_updated_epoch;
    private String last_updated;
    private float temp_c;
    private float temp_f;
    private int is_day;
    private Condition condition;
    private double wind_mph;
    private double wind_kph;
    private int wind_degree;
    private String wind_dir;
    private Double pressure_mb;
    private double pressure_in;
    private float precip_mm;
    private float precip_in;
    private int humidity;
    private int cloud;
    private double feelslike_c;
    private double feelslike_f;
    private float vis_km;
    private int vis_miles;
    private int uv;
    private float gust_mph;
    private float gust_kph;


}

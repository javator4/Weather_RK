package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Location {

    private String name;
    private String region;
    private String country;
    private float lat;
    private float lot;
    private String tz_id;
    private int localTime_epoch;
    private String localTime;

}

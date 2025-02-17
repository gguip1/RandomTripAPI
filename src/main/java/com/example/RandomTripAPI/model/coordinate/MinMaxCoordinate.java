package com.example.RandomTripAPI.model.coordinate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MinMaxCoordinate {
    private String nation;
    private double minLatitude;
    private double maxLatitude;
    private double minLongitude;
    private double maxLongitude;

    public MinMaxCoordinate(String nation, double minLatitude, double maxLatitude, double minLongitude, double maxLongitude) {
        this.nation = nation;
        this.minLatitude = minLatitude;
        this.maxLatitude = maxLatitude;
        this.minLongitude = minLongitude;
        this.maxLongitude = maxLongitude;
    }
}

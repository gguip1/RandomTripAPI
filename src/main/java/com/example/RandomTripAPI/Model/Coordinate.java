package com.example.RandomTripAPI.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Coordinate {
    private String nation;
    private double latitude;
    private double longitude;

    public Coordinate(String nation, double latitude, double longitude) {
        this.nation = nation;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

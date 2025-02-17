package com.example.RandomTripAPI.util;

import com.example.RandomTripAPI.model.coordinate.Coordinate;
import com.example.RandomTripAPI.model.coordinate.MinMaxCoordinate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CoordinateGenerator {
    private final Random random;

    public CoordinateGenerator() {
        this.random = new Random();
    }

    public Coordinate generateCoordinate(MinMaxCoordinate minMaxCoordinate) {
        double randomLatitude = minMaxCoordinate.getMinLatitude() + (minMaxCoordinate.getMaxLatitude() - minMaxCoordinate.getMinLatitude()) * random.nextDouble();
        double randomLongitude = minMaxCoordinate.getMinLongitude() + (minMaxCoordinate.getMaxLongitude() - minMaxCoordinate.getMinLongitude()) * random.nextDouble();

        return new Coordinate(minMaxCoordinate.getNation(), randomLatitude, randomLongitude);
    }
}

package com.example.RandomTripAPI.Service;

import com.example.RandomTripAPI.Model.Coordinate;
import com.example.RandomTripAPI.Model.MinMaxCoordinate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class RandomCoordinateService {
    private final Map<String, MinMaxCoordinate> coordinateMap = new HashMap<>();

    public RandomCoordinateService() {
        coordinateMap.put("South Korea", new MinMaxCoordinate("South Korea", 33.0, 38.0, 125.0, 131.0));
    }

    public MinMaxCoordinate getCoordinateMap(String nation) {
        return coordinateMap.get(nation);
    }

    public Coordinate getRandomCoordinate(String nation) {
        MinMaxCoordinate minMaxCoordinate = coordinateMap.get(nation);
        if (minMaxCoordinate != null) {
            return generateRandomCoordinate(minMaxCoordinate);
        } else {
            throw new IllegalArgumentException("Invalid nation: " + nation);
        }
    }

    private Coordinate generateRandomCoordinate(MinMaxCoordinate minMaxCoordinate) {
        Random random = new Random();
        double randomLatitude = minMaxCoordinate.getMinLatitude() + (minMaxCoordinate.getMaxLatitude() - minMaxCoordinate.getMinLatitude()) * random.nextDouble();
        double randomLongitude = minMaxCoordinate.getMinLongitude() + (minMaxCoordinate.getMaxLongitude() - minMaxCoordinate.getMinLongitude()) * random.nextDouble();

        return new Coordinate(minMaxCoordinate.getNation(), randomLatitude, randomLongitude);
    }
}

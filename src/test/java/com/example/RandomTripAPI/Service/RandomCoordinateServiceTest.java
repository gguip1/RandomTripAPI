package com.example.RandomTripAPI.Service;

import com.example.RandomTripAPI.Model.Coordinate;
import com.example.RandomTripAPI.Model.MinMaxCoordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomCoordinateServiceTest {

    @Test
    void testRandomCoordinateService() {
        RandomCoordinateService service = new RandomCoordinateService();
        MinMaxCoordinate coordinateMap = service.getCoordinateMap("South Korea");
        Coordinate coordinate = service.getRandomCoordinate("South Korea");

        System.out.println("Nation: " + coordinate.getNation());
        System.out.println("Latitude: " + coordinate.getLatitude());
        System.out.println("Longitude: " + coordinate.getLongitude());

        assertTrue(coordinate.getLatitude() >= coordinateMap.getMinLatitude() && coordinate.getLatitude() <= coordinateMap.getMaxLatitude(),
                "Latitude is out of range");
        assertTrue(coordinate.getLongitude() >= coordinateMap.getMinLongitude() && coordinate.getLongitude() <= coordinateMap.getMaxLongitude(),
                "Longitude is out of range");
    }
}

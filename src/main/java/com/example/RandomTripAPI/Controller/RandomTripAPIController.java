package com.example.RandomTripAPI.Controller;

import com.example.RandomTripAPI.Model.Coordinate;
import com.example.RandomTripAPI.Service.GoogleMapsService;
import com.example.RandomTripAPI.Service.RandomCoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RandomTripAPIController {

    private final RandomCoordinateService randomCoordinateService;
    private final GoogleMapsService googleMapsService;

    @Autowired
    public RandomTripAPIController(RandomCoordinateService randomCoordinateService, GoogleMapsService googleMapsService) {
        this.randomCoordinateService = randomCoordinateService;
        this.googleMapsService = googleMapsService;
    }

    @GetMapping("/random-coordinate")
    public Coordinate getRandomCoordinate(@RequestParam String nation) {

        return randomCoordinateService.getRandomCoordinate(nation);
    }

    @GetMapping("/random-place")
    public ResponseEntity<?> getRandomPlace(@RequestParam String nation,
                                            @RequestParam(defaultValue = "1000") int radius) {
        Coordinate coordinate = randomCoordinateService.getRandomCoordinate(nation);
        String response = googleMapsService.getPlaceNearby(coordinate.getLatitude(), coordinate.getLongitude(), radius);

        return ResponseEntity.ok(response);
    }
}

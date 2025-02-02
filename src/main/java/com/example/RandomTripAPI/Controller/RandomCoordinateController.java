package com.example.RandomTripAPI.Controller;

import com.example.RandomTripAPI.Model.Coordinate;
import com.example.RandomTripAPI.Service.RandomCoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomCoordinateController {

    @Autowired
    private RandomCoordinateService randomCoordinateService;

    @GetMapping("/api/random-coordinate/{nation}")
    public Coordinate getRandomCoordinate(@PathVariable String nation) {
        return randomCoordinateService.getRandomCoordinate(nation);
    }
}

package com.example.RandomTripAPI.Service;

import com.example.RandomTripAPI.Model.Coordinate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GoogleMapsServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private GoogleMapsService googleMapsService;

    private MockRestServiceServer mockServer;

    @BeforeEach
    void setUp() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    void testGetPlaceNearby() {
//        RandomCoordinateService service = new RandomCoordinateService();
//        Coordinate coordinate = service.getRandomCoordinate("South Korea");
//        int radius = 1000000;
//
//        String response = googleMapsService.getPlaceNearby(coordinate.getLatitude(), coordinate.getLongitude(), radius);
//
//        System.out.println(coordinate);
//        System.out.println(response);
//
//        assertNotNull(response);
    }

}

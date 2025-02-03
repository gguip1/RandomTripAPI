package com.example.RandomTripAPI.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class GoogleMapsService {
        @Value("${google.maps.api.key}")
        private String apiKey;

        private final RestTemplate restTemplate;

        public GoogleMapsService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        public String getPlaceNearby(double latitude, double longitude, int radius) {
            String apiUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"
                    + "?location=" + latitude + "," + longitude
                    + "&radius=" + radius
                    + "&key=" + apiKey;

            return restTemplate.getForObject(apiUrl, String.class);
        }
}

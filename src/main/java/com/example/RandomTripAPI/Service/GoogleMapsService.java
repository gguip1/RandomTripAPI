package com.example.RandomTripAPI.Service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleMapsService {
        private final Dotenv dotenv = Dotenv.load();

        private final String apiKey;

        private final RestTemplate restTemplate;

        public GoogleMapsService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;

//            this.apiKey = dotenv.get("GOOGLE_MAPS_API_KEY");
            this.apiKey = System.getenv("GOOGLE_MAPS_API_KEY");

            if (this.apiKey == null || this.apiKey.isEmpty()) {
                throw new IllegalStateException("Google Maps API Key is missing or invalid in .env file.");
            }
        }

        public String getPlaceNearby(double latitude, double longitude, int radius) {
            String apiUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"
                    + "?location=" + latitude + "," + longitude
                    + "&radius=" + radius
                    + "&key=" + apiKey;

            return restTemplate.getForObject(apiUrl, String.class);
        }
}

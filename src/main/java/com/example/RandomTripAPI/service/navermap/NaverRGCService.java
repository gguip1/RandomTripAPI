package com.example.RandomTripAPI.service.navermap;

import com.example.RandomTripAPI.client.NaverMapClient;
import com.example.RandomTripAPI.model.coordinate.Coordinate;
import com.example.RandomTripAPI.model.navermap.RGCResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Objects;
import java.util.Optional;

@Service
public class NaverRGCService implements RGCService {
    private final NaverMapClient naverMapClient;

    public NaverRGCService(NaverMapClient naverMapClient) {
        this.naverMapClient = naverMapClient;
    }

    @Override
    public Optional<RGCResponse> reverseGeocode(Coordinate coordinate) {
        return naverMapClient.reverseGeocode(coordinate);
    }

    @Override
    public boolean isSouthKorea(RGCResponse response) {
        if (response == null || CollectionUtils.isEmpty(response.getResults())) {
            return false;
        }
        return response.getResults().stream()
                .map(RGCResponse.Results::getRegion)
                .map(RGCResponse.Region::getArea0)
                .map(RGCResponse.Area::getName)
                .filter(Objects::nonNull)
                .anyMatch(name -> name.equalsIgnoreCase("kr"));
    }
}

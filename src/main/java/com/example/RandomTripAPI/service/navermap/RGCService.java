package com.example.RandomTripAPI.service.navermap;

import com.example.RandomTripAPI.model.coordinate.Coordinate;
import com.example.RandomTripAPI.model.navermap.RGCResponse;

import java.util.Optional;

public interface RGCService {
    Optional<RGCResponse> reverseGeocode(Coordinate coordinate);
    boolean isSouthKorea(RGCResponse response);
}

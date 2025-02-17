package com.example.RandomTripAPI.util;

import com.example.RandomTripAPI.model.coordinate.Coordinate;
import com.example.RandomTripAPI.model.coordinate.MinMaxCoordinate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoordinateGeneratorTest {

    private CoordinateGenerator coordinateGenerator;

    @BeforeEach
    void setup() {
        coordinateGenerator = new CoordinateGenerator();
    }

    @Test
    void generateCoordinate_ShouldReturnCoordinateWithinRange() {
        // 🔹 1. 테스트할 MinMaxCoordinate 설정 (대한민국 범위)
        MinMaxCoordinate minMaxCoordinate = new MinMaxCoordinate("South Korea", 33.0, 38.0, 125.0, 131.0);

        // 🔹 2. 여러 번 랜덤 좌표를 생성하여 범위 내 존재하는지 확인
        for (int i = 0; i < 100; i++) { // 100번 반복하여 검증
            Coordinate coordinate = coordinateGenerator.generateCoordinate(minMaxCoordinate);

            // 🔹 3. 검증 (위도 & 경도가 범위를 벗어나지 않아야 함)
            assertTrue(coordinate.getLatitude() >= minMaxCoordinate.getMinLatitude() &&
                            coordinate.getLatitude() <= minMaxCoordinate.getMaxLatitude(),
                    "Latitude is out of range: " + coordinate.getLatitude());

            assertTrue(coordinate.getLongitude() >= minMaxCoordinate.getMinLongitude() &&
                            coordinate.getLongitude() <= minMaxCoordinate.getMaxLongitude(),
                    "Longitude is out of range: " + coordinate.getLongitude());
        }
    }
}

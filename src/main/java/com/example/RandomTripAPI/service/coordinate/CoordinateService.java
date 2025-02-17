package com.example.RandomTripAPI.service.coordinate;

import com.example.RandomTripAPI.model.coordinate.Coordinate;
import com.example.RandomTripAPI.model.coordinate.MinMaxCoordinate;
import com.example.RandomTripAPI.model.navermap.RGCResponse;
import com.example.RandomTripAPI.service.navermap.RGCService;
import com.example.RandomTripAPI.util.CoordinateGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
public class CoordinateService {
    private final CoordinateGenerator coordinateGenerator;
    private final RGCService rgcService;

    public CoordinateService(CoordinateGenerator coordinateGenerator, RGCService rgcService) {
        this.coordinateGenerator = coordinateGenerator;
        this.rgcService = rgcService;
    }

    public Optional<Coordinate> getValidRandomCoordinate() {
        for(int i = 0; i < 10; i++) {
            Coordinate randomCoordinate = coordinateGenerator.generateCoordinate(
                    new MinMaxCoordinate("South Korea", 33.0, 38.0, 125.0, 131.0)
            );
            Optional<RGCResponse> response = rgcService.reverseGeocode(randomCoordinate);

            if(response.isEmpty()){
                log.warn("Reverse GeoCoding API 응답 없음 (좌표: {}, {})",
                        randomCoordinate.getLatitude(), randomCoordinate.getLongitude());
                continue;
            } else {
                RGCResponse rgc = response.get();

                if(rgc.getResults() != null && !rgc.getResults().isEmpty()){
                    log.info("Reverse GeoCoding API 응답: {}", rgc);
                }else {
                    log.warn("❌ Reverse GeoCoding API 응답은 존재하지만, results 리스트가 비어 있음.");
                    continue;
                }
            }

            boolean isValid = response.map(rgcService::isSouthKorea).orElse(false);

            log.info("좌표 검증 결과 (좌표: {}, {}): {}",
                    randomCoordinate.getLatitude(), randomCoordinate.getLongitude(), isValid);

            if(isValid) {
                log.info("✅ 대한민국 내 유효한 좌표 발견: {}", randomCoordinate);
                return Optional.of(randomCoordinate);
            }
        }
        log.warn("❌ 10번 시도했지만 대한민국 내 유효한 좌표를 찾지 못함.");
        return Optional.empty();
    }
}

package com.example.RandomTripAPI.controller;

import com.example.RandomTripAPI.model.coordinate.Coordinate;
import com.example.RandomTripAPI.model.error.ErrorResponse;
import com.example.RandomTripAPI.model.navermap.RGCResponse;
import com.example.RandomTripAPI.service.navermap.NaverRGCService;
import com.example.RandomTripAPI.service.coordinate.CoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class RandomTripAPIController {

    private final NaverRGCService NaverRGCService;
    private final CoordinateService coordinateService;

    @Autowired
    public RandomTripAPIController(NaverRGCService NaverRGCService, CoordinateService coordinateService) {
        this.NaverRGCService = NaverRGCService;
        this.coordinateService = coordinateService;
    }

    @GetMapping("/random-coordinate")
    public ResponseEntity<?> getRandomCoordinate(WebRequest request) {
        return coordinateService.getValidRandomCoordinate()
                .<ResponseEntity<?>>map(ResponseEntity::ok) // ✅ 성공 시 ResponseEntity<Coordinate>
                .orElseGet(() -> {
                    // ❌ 실패 시 `ErrorResponseDTO` 반환
                    ErrorResponse errorResponse = new ErrorResponse(
                            LocalDateTime.now(),
                            HttpStatus.NOT_FOUND.value(),
                            HttpStatus.NOT_FOUND.getReasonPhrase(),
                            "❌ 유효한 대한민국 좌표를 찾을 수 없습니다. 다시 시도해주세요.",
                            request.getDescription(false) // 요청 경로
                    );
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
                });    }
}

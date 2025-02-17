package com.example.RandomTripAPI.client;

import com.example.RandomTripAPI.model.coordinate.Coordinate;
import com.example.RandomTripAPI.model.navermap.RGCResponse;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

@Slf4j
@Component
public class
NaverMapClient {
    private final String clientID;
    private final String clientSecret;
    private final RestTemplate restTemplate;

    public NaverMapClient(RestTemplate restTemplate) {
//        Dotenv dotenv = Dotenv.load();
//        this.clientID = dotenv.get("NAVER_CLIENT_ID");
//        this.clientSecret = dotenv.get("NAVER_CLIENT_SECRET");
        this.clientID = System.getenv("NAVER_CLIENT_ID");
        this.clientSecret = System.getenv("NAVER_CLIENT_SECRET");
        this.restTemplate = restTemplate;
    }

    public Optional<RGCResponse> reverseGeocode(Coordinate coordinate){
        try {
            String url = "https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc?coords="
                    + coordinate.getLongitude() + ","
                    + coordinate.getLatitude() + "&output=json";

            RequestEntity<Void> request = RequestEntity
                    .get(URI.create(url))
                    .header("x-ncp-apigw-api-key-id", clientID)
                    .header("x-ncp-apigw-api-key", clientSecret)
                    .build();

            ResponseEntity<RGCResponse> response = restTemplate.exchange(request, RGCResponse.class);

            if(response.getStatusCode() == HttpStatus.OK && response.getBody() != null){
                return Optional.of(response.getBody());
            } else {
                log.warn("네이버 Reverse Geocoding API 호출 실패: {}", response.getStatusCode());
                return Optional.empty();
            }
        } catch (HttpClientErrorException e) {
            log.error("네이버 Reverse Geocoding API 요청 오류 (클라이언트 에러): HTTP 상태 코드 = {}, 메시지 = {}", e.getStatusCode(), e.getMessage());
            return Optional.empty();
        } catch (HttpServerErrorException e) {
            log.error("네이버 Reverse Geocoding API 요청 오류 (서버 에러): HTTP 상태 코드 = {}, 메시지 = {}", e.getStatusCode(), e.getMessage());
            return Optional.empty();
        } catch (RestClientException e) {
            log.error("네이버 Reverse Geocoding API 요청 오류: 메시지 = {}", e.getMessage());
            return Optional.empty();
        } catch (Exception e) {
            log.error("알 수 없는 오류: 메시지 = {}", e.getMessage());
            return Optional.empty();
        }
    }
}

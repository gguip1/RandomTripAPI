# 🌀그저 랜덤 좌표를 반환해주는 API

## #️⃣ 랜덤 좌표 생성 API
- 랜덤 좌표를 생성해주는 API입니다.

## 📍 Endpoint
`GET /api/random-coordinate`

### 🔹 요청 예시
```bash
  curl -X GET "https://old-stace-gguip1-1d7c5e3e.koyeb.app/api/random-coordinate"
```

## ✅ 성공 시 (200 OK)

### 🔹 응답 필드
| **필드**      | **타입**  | **설명** |
|:------------|:------|:--------|
| `nation`   | `string` | 국가 이름 |
| `latitude` | `double` | 위도 |
| `longitude`| `double` | 경도 |

### 🔹 응답 예시
```json
{
  "nation": "South Korea",
  "latitude": 37.5665,
  "longitude": 126.978
}
```

## ❌ 실패 시 (404 NOT FOUND)

### 🔹 응답 필드
| **필드**      | **타입**   | **설명** |
|:------------|:---------|:--------|
| `timestamp`   | `string` | 오류 발생 시간 |
| `status` | `int`    | HTTP 상태 코드 |
| `error`| `string` | 오류 유형 |
| `message` | `string`    | 오류 메시지 |
| `path`| `string` | 요청한 API 경로 |

### 🔹Production URL
- [한국 랜덤 좌표](https://old-stace-gguip1-1d7c5e3e.koyeb.app/api/random-coordinate)
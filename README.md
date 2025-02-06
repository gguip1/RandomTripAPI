## 🌀그저 랜덤 좌표를 반환해주는 API

### #️⃣ 랜덤 좌표 생성 API
- 랜덤 좌표를 생성해주는 API입니다.

### 📍 Endpoint
`GET /api/random-coordinate`

### 📌 요청 파라미터 (Query Parameters)
| **파라미터**  | **타입**  | **필수 여부** | **설명** |
|:------------|:------|:--------|:----------------|
| `nation`   | `string` | ✅ 필수 | 조회할 국가 이름 (예: `South Korea`) |

### 🔹 요청 예시
```bash
  curl -X GET "http://localhost:8080/api/random-coordinate?nation=South%20Korea"
```

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

### 🔹추후 작업
- [ ] 랜덤 좌표 기반 주변 여행지 정보 제공 API

### 🔹Production URL
- [https://random-coordinate-api.herokuapp.com/api/random-coordinate?nation=South%20Korea](https://random-coordinate-api.herokuapp.com/api/random-coordinate?nation=South%20Korea)

package project.Dong_A_Jul.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import project.Dong_A_Jul.dto.SchoolAuthenticationRequestDto;
import project.Dong_A_Jul.dto.SchoolAuthenticationResponseDto;
import project.Dong_A_Jul.dto.SignUpResponseDto;

import java.io.IOException;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @PostMapping("/school-authentication")
    public ResponseEntity<SchoolAuthenticationResponseDto> schoolAuthentication(@RequestBody SchoolAuthenticationRequestDto signUpRequestDto) {

        try{
            RestTemplate restTemplate = new RestTemplate();

// 요청 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

// 요청 바디 생성
            String requestBody = String.format("{\"id\": \"%s\", \"pw\": \"%s\"}", signUpRequestDto.getBlackboardId(), signUpRequestDto.getBlackboardPw());


// 요청 엔티티 생성
            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

// API 호출
            String apiUrl = "https://auth.imsejong.com/auth?method=ClassicSession";
            ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, requestEntity, String.class);

// 응답 처리
            if (response.getStatusCode().is2xxSuccessful()) {
                String responseBody = response.getBody();

                // JSON 파싱을 위한 ObjectMapper 객체 생성
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseBody);

                // "result" 안의 JSON 객체에서 필드 추출
                JsonNode resultNode = jsonNode.get("result");
                String isAuth = resultNode.get("is_auth").asText();
                if(isAuth.equals("false")) return ResponseEntity.badRequest().build();
                String grade = resultNode.get("body").get("grade").asText();
                String major = resultNode.get("body").get("major").asText();
                String name = resultNode.get("body").get("name").asText();

                // 추출한 값 출력 또는 사용

                return ResponseEntity.ok(SchoolAuthenticationResponseDto.builder()
                        .major(major).name(name).grade(Integer.parseInt(grade))
                                .studentId(Long.parseLong(signUpRequestDto.getBlackboardId()))
                        .build());
            }
            else{
                return ResponseEntity.badRequest().build();
            }
        } catch (JsonProcessingException e) {
            // JSON 파싱 예외 처리
            e.printStackTrace();
        } catch (IOException e) {
            // IOException 예외 처리
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();

    }

//    @PostMapping("/signup")
//    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpResponseDto signUpResponseDto){
//
//
//
//    }


}

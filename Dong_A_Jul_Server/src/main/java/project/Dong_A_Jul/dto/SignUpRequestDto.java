package project.Dong_A_Jul.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {

    //전화번호, 나이, 성별, 가입된 동아리, 관심카테고리
    private String phoneNumber;
    private int age;
    private String gender;
    private String joinedClub;
    private String category;


}

package project.Dong_A_Jul.dto;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchoolAuthenticationRequestDto {

    private String blackboardId;
    private String blackboardPw;


}

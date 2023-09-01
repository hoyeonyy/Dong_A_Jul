package project.Dong_A_Jul.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SchoolAuthenticationResponseDto {

    private Long studentId;
    private int grade;
    private String major;
    private String name;


}

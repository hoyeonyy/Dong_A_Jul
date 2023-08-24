package project.Dong_A_Jul.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.Dong_A_Jul.domain.Picture;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class IntroductionResponse {

    @NotEmpty
    private LocalDateTime recruitmentstart;
    @NotEmpty
    private LocalDateTime recruitmentend;
    @NotEmpty
    private String name;
    @NotEmpty
    private String logo; // Club picture 필드명 변경요구 - 52번째 Picture 모집글 사진과 겹친다고 생각됌
    @NotEmpty
    private String tag;
    @NotEmpty
    private Long likes;
    @NotEmpty
    private String memberlike;
    @NotEmpty
    private List<Picture> picture; // 모집글 사진
    @NotEmpty
    private String content;


    @Builder
    public IntroductionResponse(LocalDateTime recruitmentstart, LocalDateTime recruitmentend, String name, String logo, String tag, Long likes, String memberlike, List<Picture> picture, String content) {
        this.recruitmentstart = recruitmentstart;
        this.recruitmentend = recruitmentend;
        this.name = name;
        this.logo = logo;
        this.tag = tag;
        this.likes = likes;
        this.memberlike = memberlike;
        this.picture = picture;
        this.content = content;
    }
}

package project.Dong_A_Jul.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import project.Dong_A_Jul.domain.PostType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CreatePostRequest {
//    공지사항인지 게시판인지 아닌지
//    제목
//    내용
//    사진들
    private Long MemberId;

    private Long ClubId;

    private String title;

    private String content;
    private LocalDateTime created;

    @Enumerated(EnumType.STRING)
    private PostType postType;

    private List<MultipartFile> pictures = new ArrayList<>();

}

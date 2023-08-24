package project.Dong_A_Jul.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.Dong_A_Jul.domain.PostType;

@Data
public class NoticeRequest {

    @NotEmpty
    private Long clubId;

    @NotEmpty
    private Long memberId;

    @NotEmpty
    private PostType postType;

    @Builder
    public NoticeRequest(Long clubId, Long memberId, PostType postType) {
        this.clubId = clubId;
        this.memberId = memberId;
        this.postType = postType;
    }


}

package project.Dong_A_Jul.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class IntroductionRequest {
    @NotEmpty
    private Long memberId;

    @NotEmpty
    private Long clubId;

    @Builder
    public IntroductionRequest(Long memberId, Long clubId) {
        this.memberId = memberId;
        this.clubId = clubId;
    }
}

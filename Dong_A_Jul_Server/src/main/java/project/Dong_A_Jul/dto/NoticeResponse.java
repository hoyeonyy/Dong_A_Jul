package project.Dong_A_Jul.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class NoticeResponse {
    @NotEmpty
    private String title;

    @NotEmpty
    private String content;


    private LocalDateTime created;

    @Builder
    public NoticeResponse(String title, String content, LocalDateTime created) {
        this.title = title;
        this.content = content;
        this.created = created;
    }
}

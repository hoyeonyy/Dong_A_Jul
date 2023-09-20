package project.Dong_A_Jul.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import project.Dong_A_Jul.domain.Category;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllClubResponse {

    private String name;
    private String image;
    private String tag;
    private String oneline;
    private Category category;


}

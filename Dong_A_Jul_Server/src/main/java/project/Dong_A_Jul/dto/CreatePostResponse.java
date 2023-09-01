package project.Dong_A_Jul.dto;

import lombok.Data;
import project.Dong_A_Jul.domain.Post;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreatePostResponse {

    private List<Post> posts = new ArrayList<>();

}

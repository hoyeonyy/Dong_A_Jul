package project.Dong_A_Jul.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.Dong_A_Jul.dto.CreatePostRequest;
import project.Dong_A_Jul.dto.CreatePostResponse;
import project.Dong_A_Jul.service.PostService;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @PostMapping("/make")
    public ResponseEntity<CreatePostResponse> postmake(@RequestBody CreatePostRequest createPostRequest){
        CreatePostResponse createPostResponse = postService.createPost(createPostRequest);
        return ResponseEntity.ok(createPostResponse);
    }


}

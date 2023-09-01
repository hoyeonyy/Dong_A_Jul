package project.Dong_A_Jul.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.Dong_A_Jul.dto.CreatePostRequest;
import project.Dong_A_Jul.dto.CreatePostResponse;

@RestController
@RequestMapping("/api/post")
public class PostApiController {

    @PostMapping("/make")
    public ResponseEntity<CreatePostResponse> postmake(@RequestBody CreatePostRequest createPostRequest){

    }


}

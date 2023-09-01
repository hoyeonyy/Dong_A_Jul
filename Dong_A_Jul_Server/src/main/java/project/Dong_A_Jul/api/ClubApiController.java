package project.Dong_A_Jul.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.Dong_A_Jul.dto.*;
import project.Dong_A_Jul.repository.ClubJpaRepository;
import project.Dong_A_Jul.repository.MemberRepository;
import project.Dong_A_Jul.repository.PostJpaRepository;
import project.Dong_A_Jul.service.ClubLikeService;
import project.Dong_A_Jul.service.PostService;

@RestController
@RequestMapping("/api/v1/club")
@RequiredArgsConstructor
public class ClubApiController {

    private final ClubJpaRepository clubJpaRepository;
    private final MemberRepository memberRepository;
    private final ClubLikeService clubLikeService;
    private final PostService postService;
    private final PostJpaRepository postJpaRepository;

    @PostMapping("/main/introduction/") // 모집글
    public ResponseEntity<IntroductionResponse> clickIntroduction(@RequestBody IntroductionRequest introductionRequest){
        IntroductionResponse introductionResponse = postService.updateIntroduction(introductionRequest);
        return ResponseEntity.ok(introductionResponse);
    }

    @PostMapping("/main/notice")
    public ResponseEntity<NoticeResponses> clickNotice(@RequestBody NoticeRequest noticeRequest){

        NoticeResponses noticeResponses = postService.ClickNoticeOrPost(noticeRequest);
//
//        Optional<Club> findClub = clubJpaRepository.findById(noticeRequestDto.getClubId());
//        List<NoticeResponse> noticeResponses = postService.updateNotice();
//
//        noticeResponseDto.postDtos.add(postJpaRepository.findAllByClubAndPostType(findClub.get(),noticeRequestDto.postType));
//        가져온 List<post>를 가지고 PostDto에 담은다음에 List<PostDto>를 반환해서 이쪽으로 가져오면 이놈에 postDtos에 넣어서 반환하면되겠다. 위 과정들을 서비스단에서 관리해보자

        return ResponseEntity.ok(noticeResponses);
    }

    @PostMapping("/main/post")
    public ResponseEntity<NoticeResponses> clickPost(@RequestBody NoticeRequest noticeRequest){

        NoticeResponses noticeResponses = postService.ClickNoticeOrPost(noticeRequest);

        return ResponseEntity.ok(noticeResponses);
    }

}

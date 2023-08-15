package project.Dong_A_Jul.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.Dong_A_Jul.domain.Club;
import project.Dong_A_Jul.domain.Member;
import project.Dong_A_Jul.domain.Picture;
import project.Dong_A_Jul.repository.ClubJpaRepository;
import project.Dong_A_Jul.repository.MemberJpaRepository;
import project.Dong_A_Jul.service.ClubLikeService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ClubApiController {

    private final ClubJpaRepository clubJpaRepository;
    private final MemberJpaRepository memberJpaRepository;
    private final ClubLikeService clubLikeService;

    @PostMapping("/main/introduction/")
    public ResponseEntity<IntroductionResponseDto> clickIntroduction(@RequestBody IntroductionRequestDto introductionRequestDto){
        Optional<Club> findClub = clubJpaRepository.findById(introductionRequestDto.getClubId());
        Optional<Member> findMember = memberJpaRepository.findById(introductionRequestDto.getMemberId());
        IntroductionResponseDto introductionResponseDto = new IntroductionResponseDto();

        introductionResponseDto.recruitmentstart = findClub.get().getIntroduction().getRecruitmentStart();
        introductionResponseDto.recruitmentend = findClub.get().getIntroduction().getRecruitmentEnd();
        introductionResponseDto.name = findClub.get().getName();
        introductionResponseDto.logo = findClub.get().getPicture();
        introductionResponseDto.tag = findClub.get().getTag();
        introductionResponseDto.likes = findClub.get().getCountOfLikes(); //
        introductionResponseDto.memberlike = clubLikeService.MemberLikeCheck(findMember.get(), findClub.get()); // 멤버가 해당 클럽에 눌렀는지 확인해야함. 좋아요 서비스단에서 구성할수있곘다.
        introductionResponseDto.picture = findClub.get().getIntroduction().getPictures();
        introductionResponseDto.content = findClub.get().getIntroduction().getContent();




        return ResponseEntity.ok(introductionResponseDto);
    }


    @Data
    public static class IntroductionRequestDto{
        private Long memberId;
        private Long clubId;

        public IntroductionRequestDto() {
        }
    }

    @Data
    public static class IntroductionResponseDto{
        private LocalDateTime recruitmentstart;
        private LocalDateTime recruitmentend;
        private String name;
        private String logo; // Club picture 필드명 변경요구 - 52번째 Picture 모집글 사진과 겹친다고 생각됌
        private String tag;
        private Long likes;
        private String memberlike;
        private List<Picture> picture; // 모집글 사진
        private String content;

        public IntroductionResponseDto() {
        }
    }



//    동아리 id
//    맴버 id
//
//- 모집시작일
//- 모집 마감일
//- 동아리 이름
//- 동아리 로고
//- 태그
//- 좋아요 카운트
//- 좋아요 여부
//- 모집글 사진
//- 모집글 내용
}

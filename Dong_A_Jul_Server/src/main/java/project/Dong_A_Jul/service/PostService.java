package project.Dong_A_Jul.service;

import com.mysql.cj.protocol.x.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.Dong_A_Jul.domain.Club;
import project.Dong_A_Jul.domain.ClubLike;
import project.Dong_A_Jul.domain.Member;
import project.Dong_A_Jul.domain.Post;
import project.Dong_A_Jul.dto.*;
import project.Dong_A_Jul.repository.ClubJpaRepository;
import project.Dong_A_Jul.repository.MemberJpaRepository;
import project.Dong_A_Jul.repository.PostJpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class PostService {
    private final ClubJpaRepository clubJpaRepository;
    private final MemberJpaRepository memberJpaRepository;
    private final PostJpaRepository postJpaRepository;
    private final ClubLikeService clubLikeService;

    public IntroductionResponse updateIntroduction(IntroductionRequest introductionRequest){
        Optional<Club> findClub = clubJpaRepository.findById(introductionRequest.getClubId());
        Optional<Member> findMember = memberJpaRepository.findById(introductionRequest.getMemberId());
        IntroductionResponse introductionResponse = IntroductionResponse.builder()
                .recruitmentstart(findClub.get().getIntroduction().getRecruitmentStart())
                .recruitmentstart(findClub.get().getIntroduction().getRecruitmentEnd())
                .name(findClub.get().getName())
                .logo(findClub.get().getPicture())
                .likes(findClub.get().getCountOfLikes())
                .memberlike(clubLikeService.MemberLikeCheck(findMember.get(), findClub.get()))
                .picture(findClub.get().getIntroduction().getPictures())
                .content(findClub.get().getIntroduction().getContent())
                .build();

        return introductionResponse;
    }

    public NoticeRespones ClickNoticeOrPost(NoticeRequest noticeRequest){
        Optional<Club> findClub = clubJpaRepository.findById(noticeRequest.getClubId());

        NoticeRespones noticeRespones = new NoticeRespones();
        List<Post> posts = postJpaRepository.findAllByClubAndPostType(findClub.get(),noticeRequest.getPostType());

        for(Post post : posts){
            NoticeResponse noticeResponse = NoticeResponse.builder()
                    .title(post.getTitle())
                    .content(post.getContent())
                    .created(post.getCreated())
                    .build();
            noticeRespones.noticeResponses.add(noticeResponse);
        }

        return noticeRespones;
    }
}

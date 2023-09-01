package project.Dong_A_Jul.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import project.Dong_A_Jul.domain.*;
import project.Dong_A_Jul.dto.*;
import project.Dong_A_Jul.repository.ClubJpaRepository;
import project.Dong_A_Jul.repository.MemberRepository;
import project.Dong_A_Jul.repository.PictureRepository;
import project.Dong_A_Jul.repository.PostJpaRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class PostService {
    private final ClubJpaRepository clubJpaRepository;
    private final MemberRepository memberRepository;
    private final PostJpaRepository postJpaRepository;
    private final ClubLikeService clubLikeService;

    private final PictureRepository pictureRepository;

    public IntroductionResponse updateIntroduction(IntroductionRequest introductionRequest){
        Optional<Club> findClub = clubJpaRepository.findById(introductionRequest.getClubId());
        Optional<Member> findMember = memberRepository.findById(introductionRequest.getMemberId());
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

    public NoticeResponses ClickNoticeOrPost(NoticeRequest noticeRequest){
        Optional<Club> findClub = clubJpaRepository.findById(noticeRequest.getClubId());

        NoticeResponses noticeResponses = new NoticeResponses();
        List<Post> posts = postJpaRepository.findAllByClubAndPostType(findClub.get(),noticeRequest.getPostType());

        for(Post post : posts){
            NoticeResponse noticeResponse = NoticeResponse.builder()
                    .title(post.getTitle())
                    .content(post.getContent())
                    .created(post.getCreated())
                    .build();
            noticeResponses.getNoticeResponses().add(noticeResponse);
        }

        return noticeResponses;
    }


    public CreatePostResponse createPost(CreatePostRequest createPostRequest){
        Optional<Club> findClub = clubJpaRepository.findById(createPostRequest.getClubId());
        Optional<Member> findMember = memberRepository.findById(createPostRequest.getMemberId());
        try{
            Post post = Post.builder()
                    .club(findClub.get())
                    .member(findMember.get())
                    .content(createPostRequest.getContent())
                    .postType(createPostRequest.getPostType())
                    .created(LocalDateTime.now())
                    .build();

            for(MultipartFile image : createPostRequest.getPictures()){
                Picture picture = Picture.builder()
                        .post(post)
                        .imageData(image.getBytes())
                        .build();
                pictureRepository.save(picture);
            }

            postJpaRepository.save(post);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        CreatePostResponse createPostResponse = new CreatePostResponse();
        List<Post> allPost = postJpaRepository.findAllByClubAndPostType(findClub.get(),PostType.POST);

        for(Post post : allPost){
            createPostResponse.getPosts().add(post);
        }

        return createPostResponse;
    }
}

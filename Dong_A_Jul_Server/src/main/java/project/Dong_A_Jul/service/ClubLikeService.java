package project.Dong_A_Jul.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.Dong_A_Jul.domain.Club;
import project.Dong_A_Jul.domain.ClubLike;
import project.Dong_A_Jul.domain.Member;
import project.Dong_A_Jul.repository.ClubLikeJpaRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ClubLikeService {

    private final ClubLikeJpaRepository clubLikeJpaRepository;

    public String MemberLikeCheck(Member member, Club club){
        ClubLike clublike = clubLikeJpaRepository.findByMemberAndClub(member,club);
        if(clublike == null){
            return "No";
        }
        return "Yes";
    }

}

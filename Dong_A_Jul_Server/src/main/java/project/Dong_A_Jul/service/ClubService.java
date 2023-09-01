package project.Dong_A_Jul.service;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.Dong_A_Jul.repository.ClubJpaRepository;
import project.Dong_A_Jul.repository.MemberRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClubService {

    private final EntityManager em;
    private final MemberRepository memberRepository;
    private final ClubJpaRepository clubJpaRepository;


//    @Transactional
//    public Long validMemberLike(... ){ // 회원이 좋아요를 눌렀는지 검증하는 코드
//
//    }

}

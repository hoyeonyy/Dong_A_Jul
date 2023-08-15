package project.Dong_A_Jul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.Dong_A_Jul.domain.Club;
import project.Dong_A_Jul.domain.ClubLike;
import project.Dong_A_Jul.domain.Member;

public interface ClubLikeJpaRepository extends JpaRepository<ClubLike,Long> {
    ClubLike findByMemberAndClub(Member member, Club club);
}

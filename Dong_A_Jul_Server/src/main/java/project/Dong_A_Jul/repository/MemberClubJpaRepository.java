package project.Dong_A_Jul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.Dong_A_Jul.domain.MemberClub;

public interface MemberClubJpaRepository extends JpaRepository<MemberClub, Long> {
}
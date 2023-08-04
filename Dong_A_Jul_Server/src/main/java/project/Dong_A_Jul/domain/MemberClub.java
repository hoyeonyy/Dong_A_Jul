package project.Dong_A_Jul.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class MemberClub {

    @Id @GeneratedValue
    @Column(name = "memberclub_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

}

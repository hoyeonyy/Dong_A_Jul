package project.Dong_A_Jul.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Admin {

    @Id @GeneratedValue
    @Column(name = "admin_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

}

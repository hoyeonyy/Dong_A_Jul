package project.Dong_A_Jul.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Club {


    @Id @GeneratedValue
    @Column(name = "club_id")
    private Long id;

    private String name;
    private Category category;
    private String picture;
    private String tag;

    private String oneline;
    private String location;

    @Formula("(select count(*) from clublike cl from cl.club_id = id)")
    private Long likes;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "introduction_id")
    private Introduction introduction;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "club")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY)
    private List<ClubLike> clubLikes = new ArrayList<>();

    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY)
    private List<MemberClub> memberClubs = new ArrayList<>();

    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY)
    private List<Admin> admins = new ArrayList<>();

    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY)
    private List<Application> applications = new ArrayList<>();

    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY)
    private List<OriginalMember> originalMembers = new ArrayList<>();

    public Long getCountOfLikes(){
        return this.likes;
    }
}

/**
 * 하이버네이트의 Fomula 어노테이션을 사용하여 "likes"라는 가상의 컬럼을 만들어 하위쿼리를 작성하여 카운트문제를 해결하려고했다.
 * [참고내용]
 * https://www.popit.kr/jpa-엔터티-카운트-성능-개선하기/
 */
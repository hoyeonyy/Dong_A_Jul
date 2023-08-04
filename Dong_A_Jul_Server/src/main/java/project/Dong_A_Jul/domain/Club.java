package project.Dong_A_Jul.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Club {

    @Id @GeneratedValue
    @Column(name = "club_id")
    private Long id;

    private String name;
    private Category category;
    private String picture;
    private String tag;

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
}

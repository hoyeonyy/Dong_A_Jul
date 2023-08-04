package project.Dong_A_Jul.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private long id;

    private String blackBoardId;
    private String blackBoardPw;
    private String name;
    private String gender;
    private String major;
    private int age;
    private Long studentId;
    private int grade;
    private String phone;
    private String image;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<PostLike> postLikes = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<ClubLike> clubLikes = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<MemberClub> memberClubs = new ArrayList<>();

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private Admin admin;

}

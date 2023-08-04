package project.Dong_A_Jul.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Picture {

    @Id @GeneratedValue
    @Column(name = "picture_id")
    private Long id;

    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "introduction_id")
    private Introduction introduction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;


}

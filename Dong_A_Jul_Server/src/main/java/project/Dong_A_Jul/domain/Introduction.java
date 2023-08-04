package project.Dong_A_Jul.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Introduction {

    @Id @GeneratedValue
    @Column(name = "introduction_id")
    private Long id;

    private String title;
    private String content;
    private LocalDateTime recruitmentStart;
    private LocalDateTime recruitmentEnd;

    @OneToOne(mappedBy = "introduction",fetch = FetchType.LAZY)
    private Club club;

    @OneToMany( mappedBy = "introduction", fetch = FetchType.LAZY)
    private List<Picture> pictures = new ArrayList<>();


}

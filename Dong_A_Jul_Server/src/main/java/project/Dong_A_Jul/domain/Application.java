package project.Dong_A_Jul.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Application {

    @Id @GeneratedValue
    @Column(name = "application_id")
    private Long id;

    private LocalDateTime created;

    private LocalDateTime modified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    @OneToMany(mappedBy = "application", fetch = FetchType.LAZY)
    private List<Question> questions = new ArrayList<>();

}

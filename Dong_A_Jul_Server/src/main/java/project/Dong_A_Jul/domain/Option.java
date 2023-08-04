package project.Dong_A_Jul.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Option {


    @Id @GeneratedValue
    @Column(name = "option_id")
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

}

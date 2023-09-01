package project.Dong_A_Jul.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id @GeneratedValue
    @Column(name = "question_id")
    private Long id;

    private String content;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;


    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Option> options = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "question")
    private Answer answer;

}

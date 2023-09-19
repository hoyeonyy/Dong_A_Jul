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

    @Enumerated(EnumType.STRING)
    private Category category;

    private String picture;

    private String tag;

    private String oneline;

}
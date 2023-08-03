package project.Dong_A_Jul.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
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

    private enum category;


}

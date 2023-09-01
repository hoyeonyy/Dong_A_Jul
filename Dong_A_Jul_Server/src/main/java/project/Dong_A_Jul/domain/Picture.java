package project.Dong_A_Jul.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Picture {

    @Id @GeneratedValue
    @Column(name = "picture_id")
    private Long id;

    @Lob //@Lob 어노테이션을 사용하면 대형 객체를 효과적으로 데이터베이스에 저장하고 조회할 수 있습니다.
    private byte[] imageData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "introduction_id")
    private Introduction introduction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;



    public void setPost(Post post) {
        if(this.post != null){
            this.post.getPictures().remove(this);
        }
        this.post = post;
        post.getPictures().add(this);
    }
}

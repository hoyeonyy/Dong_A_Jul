package project.Dong_A_Jul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.Dong_A_Jul.domain.Club;
import project.Dong_A_Jul.domain.Post;
import project.Dong_A_Jul.domain.PostType;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post,Long> {

    List<Post> findAllByClubAndPostType(Club club, PostType postType);
}

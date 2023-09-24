package project.Dong_A_Jul.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.Dong_A_Jul.domain.Club;
import project.Dong_A_Jul.domain.QClub;
import project.Dong_A_Jul.dto.AllClubResponse;

import java.util.ArrayList;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class ClubQueryRepository {

    @PersistenceContext
    private EntityManager em;
    private JPAQueryFactory queryFactory;
    @PostConstruct
    public void init() {
        queryFactory = new JPAQueryFactory(em);
    }
    private QClub club = new QClub("club");

    public List<Club> findClubByName(String name){


        List<Club> result = queryFactory
                .select(club)
                .from(club)
                .where(club.name.contains(name))
                .fetch();

        return result;

    }


}

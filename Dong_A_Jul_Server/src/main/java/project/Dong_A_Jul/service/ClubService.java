package project.Dong_A_Jul.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.Dong_A_Jul.domain.Club;
import project.Dong_A_Jul.dto.AllClubResponse;
import project.Dong_A_Jul.dto.AllClubResponses;
import project.Dong_A_Jul.repository.ClubRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClubService {

    private final ClubRepository clubRepository;

    public AllClubResponses findAllClub(){

        AllClubResponses allClubResponses = new AllClubResponses();
        List<Club> all = clubRepository.findAll();
        for (Club club : all) {
            AllClubResponse allClubResponse = AllClubResponse.builder()
                    .name(club.getName())
                    .image(club.getPicture())
                    .oneline(club.getOneline())
                    .tag(club.getTag())
                    .category(club.getCategory())
                    .build();
            allClubResponses.getList().add(allClubResponse);
        }

        return allClubResponses;
    }



}

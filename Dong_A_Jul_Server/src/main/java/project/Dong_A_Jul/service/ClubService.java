package project.Dong_A_Jul.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.Dong_A_Jul.domain.Club;
import project.Dong_A_Jul.dto.AllClubResponse;
import project.Dong_A_Jul.dto.AllClubResponses;
import project.Dong_A_Jul.repository.ClubQueryRepository;
import project.Dong_A_Jul.repository.ClubRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClubService {

    private final ClubRepository clubRepository;
    private final ClubQueryRepository clubQueryRepository;

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
    public AllClubResponses findByName(String name){

        List<Club> result = clubQueryRepository.findClubByName(name);
        AllClubResponses allClubResponses = new AllClubResponses();

        for (Club c : result) {
            AllClubResponse build = AllClubResponse.builder()
                    .tag(c.getTag())
                    .oneline(c.getOneline())
                    .name(c.getName())
                    .image(c.getPicture())
                    .build();
            allClubResponses.getList().add(build);
        }
        return allClubResponses;
    }



}

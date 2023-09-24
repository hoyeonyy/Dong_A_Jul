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
                    .category(c.getCategory())
                    .build();
            allClubResponses.getList().add(build);
        }

//        result.stream() // 리스트를 스트림으로 변환합니다.
//                .map(c -> AllClubResponse.builder() // 각 'Club' 객체 c를 AllClubResponse 객체로 변환합니다. map연산은 각 요소를 변환하고 새로운 스트림을 생성합니다.
//                        .tag(c.getTag())
//                        .oneline(c.getOneline())
//                        .name(c.getName())
//                        .image(c.getPicture())
//                        .category(c.getCategory())
//                        .build())
//                .forEach(allClubResponses.getList()::add); // 각 변환된 AllClubResponse 객체를 allClubResponses 객체의 'list' 필드에 추가합니다.
        // Club 객체를 AllClubResponse 객체로 변환하고, 이 객체들을 allClubResponses의 list객체에 추가하는 작업입니다.


        return allClubResponses;
    }



}

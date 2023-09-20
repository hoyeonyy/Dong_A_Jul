package project.Dong_A_Jul.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.Dong_A_Jul.dto.AllClubResponse;
import project.Dong_A_Jul.dto.AllClubResponses;
import project.Dong_A_Jul.service.ClubService;

@RestController
@RequiredArgsConstructor
public class ClubApi {

    private final ClubService clubService;

    @GetMapping("api/allclub")
    public ResponseEntity<AllClubResponses> allClub(){

        AllClubResponses allClub = clubService.findAllClub();

        return ResponseEntity.ok(allClub);

    }

}

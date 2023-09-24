package project.Dong_A_Jul.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.Dong_A_Jul.dto.AllClubResponse;
import project.Dong_A_Jul.dto.AllClubResponses;
import project.Dong_A_Jul.service.ClubService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ClubApi {

    private final ClubService clubService;

    @GetMapping("/allclub")
    public ResponseEntity<AllClubResponses> allClub(){

        AllClubResponses allClub = clubService.findAllClub();

        return ResponseEntity.ok(allClub);

    }
    @GetMapping("/find-club")
    public ResponseEntity<AllClubResponses> findByNameClub(@RequestParam("name") String name){

        AllClubResponses result = clubService.findByName(name);

        return ResponseEntity.ok(result);

    }

}

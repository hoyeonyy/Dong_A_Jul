package project.Dong_A_Jul.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllClubResponses {

    private ArrayList<AllClubResponse> list = new ArrayList<>();

}

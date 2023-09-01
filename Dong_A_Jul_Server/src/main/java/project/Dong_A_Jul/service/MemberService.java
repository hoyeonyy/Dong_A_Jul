package project.Dong_A_Jul.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.Dong_A_Jul.domain.Authority;
import project.Dong_A_Jul.domain.Club;
import project.Dong_A_Jul.domain.Member;
import project.Dong_A_Jul.domain.OriginalMember;
import project.Dong_A_Jul.dto.SignUpRequestDto;
import project.Dong_A_Jul.dto.SignUpResponseDto;
import project.Dong_A_Jul.repository.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

//    @Transactional
//    public SignUpRequestDto signUp(SignUpRequestDto signUpRequestDto){
//        /**
//         * 이건 설문종료후 회원가입
//         *
//         * private String phoneNumber;
//         *     private int age;
//         *     private String gender;
//         *     private String joinedClub;
//         *     private String category;
//         * */
//        Authority authority = Authority.builder()
//                .authorityName("ROLE_USER")
//                .build();
//
//        Club club = Club.builder()
//
//
//
//        Member member = Member.builder()
//                .age(signUpRequestDto.getAge())
//                .phone(signUpRequestDto.getPhoneNumber())
//                .gender(signUpRequestDto.getGender())
//                .originalMember();
//
//    }
}

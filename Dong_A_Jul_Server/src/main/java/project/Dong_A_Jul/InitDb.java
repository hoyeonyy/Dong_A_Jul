package project.Dong_A_Jul;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.Dong_A_Jul.domain.Category;
import project.Dong_A_Jul.domain.Club;
import project.Dong_A_Jul.repository.ClubRepository;

/**
 * 모든 운동을 데이터베이스에 저장해두고 시작한다.
 */
@Component
@RequiredArgsConstructor
public class InitDb {

    @Autowired
    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1(); // 공연
        initService.dbInit2(); // 문화
        initService.dbInit3(); // 봉사
        initService.dbInit4(); // 종교
        initService.dbInit5(); // 체육
        initService.dbInit6(); // 학술
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final ClubRepository clubRepository;

        public void dbInit1() { // 공연 저장
            Club club1 = Club.builder()
                    .name("더블랙")
                    .category(Category.GY)
                    .tag("공연")
                    .picture("https://s3.us-west-2.amazonaws.com/secure.notion-static.com/0273a558-1d1d-4ae0-b5cf-801c73d55796/더블랙.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230919%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230919T112419Z&X-Amz-Expires=3600&X-Amz-Signature=ccd0b52f1ad8cb8feff4d5482a2ed47c5a7363cfca3bf63a0e21d8712b76800b&X-Amz-SignedHeaders=host&x-id=GetObject")
                    .oneline("2006년 설립된 중앙 보컬동아리 더블랙입니다. 저희는 노래를 좋아하는 학생들이 모여 다양한 장르를 공연하는 동아리입니다. 화음을 맞춰 공연해보고 싶거나 노래를 좋아하는 분이라면 누구든 환영입니다.")
                    .build();

            clubRepository.save(club1);

            Club club2 = Club.builder()
                    .name("사운드플러스")
                    .category(Category.GY)
                    .tag("공연")
                    .picture("https://s3.us-west-2.amazonaws.com/secure.notion-static.com/5bced41e-b444-476f-9b84-d1915455973d/사운드플러스.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230919%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230919T112419Z&X-Amz-Expires=3600&X-Amz-Signature=7f65fb901c5363d032f805d54bdd65813cb5ceaa394c8a0fe2ab984df5ad6f04&X-Amz-SignedHeaders=host&x-id=GetObject")
                    .oneline("올해로 32기가 된 밴드 동아리입니다. 동아리명처럼 부원들이 서로 교류하며 좋은 공연을 해오고 있습니다.")
                    .build();

            clubRepository.save(club2);

            Club club3 = Club.builder()
                    .name("세종극회")
                    .category(Category.GY)
                    .tag("공연")
                    .picture("https://s3.us-west-2.amazonaws.com/secure.notion-static.com/36df74c4-0f77-482e-9ab2-45f7ac654911/세종극회.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230919%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230919T112419Z&X-Amz-Expires=3600&X-Amz-Signature=0ad14056ee3dd3628c5df4883272d7c17bc8456bbae93933ca36b7c068e8017d&X-Amz-SignedHeaders=host&x-id=GetObject")
                    .oneline("중앙 연극동아리 ‘세종극회'입니다. 세종극회는 연기, 연출, 소품 등의 분야가 모여 공연 준비를 하여 정기적인 연극 공연을 올립니다.")
                    .build();

            clubRepository.save(club3);

            Club club4 = Club.builder()
                    .name("터벌림")
                    .category(Category.GY)
                    .tag("공연")
                    .picture("https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c88e924f-a5a4-46fb-8d03-c5cc3794e2ad/터벌림_로고.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230919%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230919T112419Z&X-Amz-Expires=3600&X-Amz-Signature=c25f47716a3aaa5c0c005aae8b4fd7054e6de7be96b19eed7d8d4fc54f110e00&X-Amz-SignedHeaders=host&x-id=GetObject")
                    .oneline("1984년 창립된 중앙 풍물동아리입니다. 악기 연습, 공연 준비, 전수 등의 활동을 합니다. 우리의 얼을 찾고 넓히며 국악의 흥겨움을 전합니다.")
                    .build();

            clubRepository.save(club4);

            Club club5 = Club.builder()
                    .name("소울트레인")
                    .category(Category.GY)
                    .tag("공연")
                    .picture("https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1ce76d91-b9bd-49fc-a236-ac3d8d196909/소울트레인.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230919%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230919T112419Z&X-Amz-Expires=3600&X-Amz-Signature=6d3855c9e02f521b4e1f597b9677bb271f536f9a9cab858e9e585591ae08b5a3&X-Amz-SignedHeaders=host&x-id=GetObject")
                    .oneline("2005년 설립된 중앙흑인음악동아리 소울트레인입니다. 주된 활동은 교내 행사에서의 공연과 외부공연장에서의 정기공연이며, 곡 작업 및 스터디, 공연을 위한 연습을 진행합니다.")
                    .build();

            clubRepository.save(club5);

            Club club6 = Club.builder()
                    .name("PAGE7")
                    .category(Category.GY)
                    .tag("공연")
                    .picture("https://s3.us-west-2.amazonaws.com/secure.notion-static.com/5e502584-300a-4ec8-bb10-e70c4a8a037a/페이지세븐.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230919%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230919T112419Z&X-Amz-Expires=3600&X-Amz-Signature=66810651294d214b0ebd7b9da900949fed34be8fa634bc6aa2e7a848cdc8a2f4&X-Amz-SignedHeaders=host&x-id=GetObject")
                    .oneline("락, 어쿠스틱, 발라드, 팝 다해버리는 중앙 밴드동아리 PAGE7입니다. OT, 대동제, 힘미제 등 교내 행사 무대, 타 학교 협동 공연과 초심자들을 위한 악기 레슨을 진행하고 있습니다.")
                    .build();

            clubRepository.save(club6);


            Club club7 = Club.builder()
                    .name("인트로")
                    .category(Category.GY)
                    .tag("공연")
                    .picture("https://s3.us-west-2.amazonaws.com/secure.notion-static.com/a3d16a6d-2ff2-4ffa-a919-d1b01bbfacfe/인트로.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230919%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230919T112419Z&X-Amz-Expires=3600&X-Amz-Signature=9d424cd10348609e9271fa47d1ec525e40b9ecacf6f4c35b0997b1295d932806&X-Amz-SignedHeaders=host&x-id=GetObject")
                    .oneline("춤과 랩을 즐기며 열정이 넘치는 중앙힙합동아리로, 교내행사 및 자체 정기공연을 통해 대학생활에 잊지못할 추억을 남겨드립니다!")
                    .build();

            clubRepository.save(club7);


            Club club8 = Club.builder()
                    .name("늘혬코러스")
                    .category(Category.GY)
                    .tag("공연")
                    .picture("https://s3.us-west-2.amazonaws.com/secure.notion-static.com/792fa45a-59c5-4b4a-9044-acbad2a48973/늘혬코러스.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230919%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230919T112419Z&X-Amz-Expires=3600&X-Amz-Signature=78ad52aaae7508f0e1006d7d84d769826bed4ddd82b4482f18078a11d1ec1835&X-Amz-SignedHeaders=host&x-id=GetObject")
                    .oneline("1988년 설립된 중앙 밴드동아리 늘혬코러스입니다. 합주 및 스터디를 통해 정기적으로 공연을 진행하고 있습니다.")
                    .build();

            clubRepository.save(club8);


            Club club9 = Club.builder()
                    .name("한울림")
                    .category(Category.GY)
                    .tag("공연")
                    .picture("")
                    .oneline("기타를 가르치고 배우고 연주하고 감상하면서 음악을 통해 사람들과 친목을 쌓는 동아리입니다.")
                    .build();

            clubRepository.save(club9);
        }

        public void dbInit2() { // 문화 저장
            Club club1 = Club.builder()
                    .name("투두 TO-DO")
                    .category(Category.MH)
                    .tag("문화")
                    .picture("")
                    .oneline("'투두 TO-DO'는 청춘의 한 페이지를 함께 만들어가자는 취지에서 만든 동아리입니다. <서울점령전>, <회장을 잡아라>, <소맘공> 등 매달 정해진 주제의 조 활동이 있어 다양한 추억들을 쌓을 수 있습니다.")
                    .build();

            clubRepository.save(club1);

            Club club2 = Club.builder()
                    .name("두바퀴")
                    .category(Category.MH)
                    .tag("문화")
                    .picture("")
                    .oneline("두바퀴는 바이크 혹은 운전면허 소지여부와 상관없이, 바이크를 좋아하고 관심있는 사람이라면 함께 즐길 수 있는 동아리입니다. 매주 정해진 요일에 서울 근교로 정기마실을 가고, 한 달에 한번 전국 방방곡곡을 누비는 투어와 분기별 MT를 갑니다. 바이크 입문에 관심있다면 언제든 환영입니다!")
                    .build();

            clubRepository.save(club2);

            Club club3 = Club.builder()
                    .name("BAMBOO")
                    .category(Category.MH)
                    .tag("문화")
                    .picture("")
                    .oneline("2014년에 설립된 밤부는 캐주얼 사진동아리입니다. 촬영 장비에 구애를 받지 않고 사진찍고자 하는 마음만 있다면 누구나 함께 할 수 있는 사진 동아리입니다. 매달 정기출사와 1년에 2번 사진전을 개최합니다.")
                    .build();

            clubRepository.save(club3);

            Club club4 = Club.builder()
                    .name("한손")
                    .category(Category.MH)
                    .tag("문화")
                    .picture("")
                    .oneline("오랜 역사를 가진 만화 동아리 한손입니다. 매년마다 창립제와 회지 발간, 그 외 다양한 활동을 통해 친목과 경험을 쌓고 있습니다.")
                    .build();

            clubRepository.save(club4);

            Club club5 = Club.builder()
                    .name("MIS")
                    .category(Category.MH)
                    .tag("문화")
                    .picture("")
                    .oneline("지방에서 고등학교를 마치고 서울로 처음 올라오는 학생들을 위한 서울탐방과, 고등학생 때 해보지 못한 활동들을 동아리를 통해서 여러 사람들과 어울려 할 수 있는 문화생활동아리!")
                    .build();

            clubRepository.save(club5);

            Club club6 = Club.builder()
                    .name("유스호스텔")
                    .category(Category.MH)
                    .tag("문화")
                    .picture("")
                    .oneline("1967년 설립된 중앙 여행동아리 유스호스텔입니다. 국내 여러 곳 여행 및 타 대학과의 연합 또한 정기적으로 진행 중입니다.")
                    .build();

            clubRepository.save(club6);


            Club club7 = Club.builder()
                    .name("마스")
                    .category(Category.MH)
                    .tag("문화")
                    .picture("")
                    .oneline("1967년 설립된 중앙 여행동아리 유스호스텔입니다. 국내 여러 곳 여행 및 타 대학과의 연합 또한 정기적으로 진행 중입니다.")
                    .build();

            clubRepository.save(club7);
        }

        public void dbInit3() { // 봉사 저장
            Club club1 = Club.builder()
                    .name("셀스")
                    .category(Category.BS)
                    .tag("봉사")
                    .picture("")
                    .oneline("세종대학교 중앙 영어봉사 동아리 셀스입니다. 다양한 프로그램들을 통해 초등학생들이 영어와 친해질 수 있게 도와주고 있습니다.")
                    .build();

            clubRepository.save(club1);

            Club club2 = Club.builder()
                    .name("죽순회")
                    .category(Category.BS)
                    .tag("봉사")
                    .picture("")
                    .oneline("정기 봉사활동과 비정기 봉사활동을 함께 진행합니다. 봉사뿐만 아니라 MT, 집회, 건대 죽순회와의 교류 등을 통해 친목활동도 하고 있습니다.")
                    .build();

            clubRepository.save(club2);
        }

        public void dbInit4() { // 봉사 저장
            Club club1 = Club.builder()
                    .name("레지나")
                    .category(Category.ZG)
                    .tag("종교")
                    .picture("")
                    .oneline("세종대학교 가톨릭 학생회 레지나입니다. 하느님의 사랑을 배우고, 나누며, 몸소 실천하여 학교 복음화에 기여하고자 하는 것이 기본 목적입니다.")
                    .build();

            clubRepository.save(club1);

            Club club2 = Club.builder()
                    .name("KSGI")
                    .category(Category.ZG)
                    .tag("종교")
                    .picture("")
                    .oneline("SGI는 Soka Gakki International 의 약자로 국제창가학회를 뜻하며, 1930년 창립된 이래 생명존엄의 불법을 기조로 인류의 평화와 행복을 위해 노력하는 단체로 해당 종교의 동아리입니다.")
                    .build();

            clubRepository.save(club2);

            Club club3 = Club.builder()
                    .name("CCC")
                    .category(Category.ZG)
                    .tag("종교")
                    .picture("")
                    .oneline("전국 300여개 대학교에서 활동 중인 기독교 동아리 CCC입니다. 크리스천 신앙 훈련 활동들과 누구나 함께 할 수 있는 수련회, 단기선교 등 다양한 대외 활동을 하고 있습니다.")
                    .build();

            clubRepository.save(club3);

            Club club4 = Club.builder()
                    .name("JYM")
                    .category(Category.ZG)
                    .tag("종교")
                    .picture("")
                    .oneline("JYM(Joyful Youth Mission)은 복음적 선교단체(KAICAM,기연 소속)입니다. 캠퍼스의 한 사람을 목자로 세워 열방을 제자화 하는 것을 사명으로 삼고 있습니다.")
                    .build();

            clubRepository.save(club4);

            Club club5 = Club.builder()
                    .name("IVF")
                    .category(Category.ZG)
                    .tag("종교")
                    .picture("")
                    .oneline("IVF(한국기독학생회)는 전국 150여 개 캠퍼스에서 '캠퍼스와 세상 속의 하나님 나라 운동'을 모토로 활동하고 있는 학원복음화협의회 소속된 건강한 복음주의 학생운동 단체입니다.")
                    .build();

            clubRepository.save(club5);
        }


        public void dbInit5() { // 봉사 저장
            Club club1 = Club.builder()
                    .name("FC해례본")
                    .category(Category.CY)
                    .tag("체육")
                    .picture("")
                    .oneline("2021년에 새롭게 창립된 FC해례본 입니다. 한글이 신분에 구애를 받지 않듯 과, 학번에 구애받지 않고 다 같이 풋살과 축구를 즐기며 친분을 도모하고 체력증진을 목적으로 하고 있으며 자체경기, 타 대학 동아리와 친선경기를 진행하고 있습니다.")
                    .build();

            clubRepository.save(club1);

            Club club2 = Club.builder()
                    .name("RUSH")
                    .category(Category.CY)
                    .tag("체육")
                    .picture("")
                    .oneline("세종대학교 중앙 농구 동아리 RUSH 입니다. 체육활동, 문화활동을 기반으로 진행하고 있으며, 4명의 임원진을 통해 탄탄한 운영을 하고 있습니다. 농구를 좋아하는 남녀노소 모두 신청이 가능합니다.")
                    .build();

            clubRepository.save(club2);

            Club club3 = Club.builder()
                    .name("발파람")
                    .category(Category.CY)
                    .tag("체육")
                    .picture("")
                    .oneline("20년 역사를 가진 택견동아리 발파람입니다. 택견은 가벼운 개인운동과 무거운 격투기 스포츠의 성격을 가진 운동입니다. 기본적으로 매주 모여 운동을 하고 있으며, 매년 열리는 서울시대회, 생활체육대회, 전국체육대회에 참가해 좋은 성적을 거두고 있습니다.")
                    .build();

            clubRepository.save(club3);

            Club club4 = Club.builder()
                    .name("세종킹스")
                    .category(Category.CY)
                    .tag("체육")
                    .picture("")
                    .oneline("1999년에 창단된 세종대학교 중앙 야구동아리로 야구실력 증진과 친목도모가 목적입니다. 대학아마야구협회(AUBL)에 소속되어 리그에 참가하고 있으며, 그 외에도 KUSF, KUBA 등 다양한 대회에 참여하고 있습니다. 또한 프로야구 직관이나 MT 등의 친목활동도 활발히 하고 있습니다.")
                    .build();

            clubRepository.save(club4);

            Club club5 = Club.builder()
                    .name("세증스키")
                    .category(Category.CY)
                    .tag("체육")
                    .picture("")
                    .oneline("1999년에 창단된 세종대학교 중앙 야구동아리로 야구실력 증진과 친목도모가 목적입니다. 대학아마야구협회(AUBL)에 소속되어 리그에 참가하고 있으며, 그 외에도 KUSF, KUBA 등 다양한 대회에 참여하고 있습니다. 또한 프로야구 직관이나 MT 등의 친목활동도 활발히 하고 있습니다.")
                    .build();

            clubRepository.save(club5);

            Club club6 = Club.builder()
                    .name("요트부")
                    .category(Category.CY)
                    .tag("체육")
                    .picture("")
                    .oneline("세일링 요트를 타고 바람을 이용해 세일링 하는 법을 배우며, 일주일에 한 번씩 한강에서 세일링을 진행합니다. 다른 학교와도 친해지며 재밌게 요트를 탈 수 있는 동아리입니다.")
                    .build();

            clubRepository.save(club6);

            Club club7 = Club.builder()
                    .name("점프")
                    .category(Category.CY)
                    .tag("체육")
                    .picture("")
                    .oneline("학기 중에는 스케이트보드 혹은 롱보드를 타고 여름엔 서핑 및 웨이크보드, 겨울엔 스노우보드를 타는 것을 주 목적으로 만들어진 동아리입니다. 주 활동은 스노우보드이고 그에 따라 겨울에 모든 포커스가 맞춰져 있습니다. 스노우보드를 타보셨던 분도, 타보지 않으셨던 분도 재미있게 타고자 만든 동아리입니다.")
                    .build();

            clubRepository.save(club7);

            Club club8 = Club.builder()
                    .name("ESCAPER")
                    .category(Category.CY)
                    .tag("체육")
                    .picture("")
                    .oneline("Escaper는 정해진 시간표 내에서 원하는 시간대에 오시면 같이 모여서 운동하는 주짓수 동아리입니다! 단순한 음주,가무만 존재하는 친목 모임이 아닌 선 운동, 후 친목이 이루어지는 바람직한 모임입니다! 검은띠 관장님의 체계적인 지도로 모두 건강해지고 강해집시다!")
                    .build();

            clubRepository.save(club8);

            Club club9 = Club.builder()
                    .name("산악부")
                    .category(Category.CY)
                    .tag("체육")
                    .picture("")
                    .oneline("등산과 등반을 통해 체력과 정신력을 기르며, 일상에서는 보기 힘든 멋진 풍경을 보고 특별한 경험을 할 수 있습니다.")
                    .build();

            clubRepository.save(club9);

            Club club10 = Club.builder()
                    .name("STC")
                    .category(Category.CY)
                    .tag("체육")
                    .picture("")
                    .oneline("1981년에 창립된 Sejong Tennis Club STC입니다. 테니스를 통한 동아리원간의 친선도모와 실력향상을 목적으로 하고, 트레이닝 및 경기연습, 타 대학과 친선경기를 하고 있습니다.")
                    .build();

            clubRepository.save(club10);

            Club club11 = Club.builder()
                    .name("TSP")
                    .category(Category.CY)
                    .tag("체육")
                    .picture("")
                    .oneline("2012년 설립된 중앙 탁구동아리 TSP입니다. 매주 월요일과 목요일에 군자탁구장에서 모임을 진행합니다. 정기적으로 리그를 진행하고 있습니다. 타 대학과의 교류전과 각종 대회에 자주 참여하고 있습니다.")
                    .build();

            clubRepository.save(club11);
        }

        public void dbInit6() { // 봉사 저장
            Club club1 = Club.builder()
                    .name("EN#")
                    .category(Category.HS)
                    .tag("학술")
                    .picture("")
                    .oneline("En#은 올해로 22년 된 프로그래밍 학술 동아리입니다. 활동 기간동안 함께 스터디하고 공모전에 참가하며 프로그래밍 실력을 쌓고 있습니다.")
                    .build();

            clubRepository.save(club1);

            Club club2 = Club.builder()
                    .name("별무리")
                    .category(Category.HS)
                    .tag("학술")
                    .picture("")
                    .oneline("교내 유일한 천체관측 동아리로 정기적으로 교내 혹은 교외에서 천체를 관측합니다. 전문적인 지식이 없어도 함께 즐기며 친목을 도모할 수 있는 동아리입니다.")
                    .build();

            clubRepository.save(club2);

            Club club3 = Club.builder()
                    .name("세종서회")
                    .category(Category.HS)
                    .tag("학술")
                    .picture("")
                    .oneline("1981년 설립된 중앙 서예동아리 세종서회입니다. 전문 서예 선생님으로부터 한글/한문 서예를 배우며 정기전시회를 통해 자신만의 작품을 만들어 나갑니다.")
                    .build();

            clubRepository.save(club3);

            Club club4 = Club.builder()
                    .name("세종문학회")
                    .category(Category.HS)
                    .tag("학술")
                    .picture("")
                    .oneline("세종문학회는 서적이나 사회의 각종 이슈를 정하여 토론을 하며 논리적인 사고능력과 체계적인 주장 능력을 기르는 활동을 하고 있습니다. 행사 외에는 단체 공연관람 같은 문화 활동을 운영하고 있습니다.")
                    .build();

            clubRepository.save(club4);


            Club club5 = Club.builder()
                    .name("인터페이스")
                    .category(Category.HS)
                    .tag("학술")
                    .picture("")
                    .oneline("1988년에 설립된 중앙 학술 프로그래밍 동아리 인터페이스입니다. 스터디, 해커톤, 프로젝트 전시회 등 다양한 활동을 통해 사람과 컴퓨터를 잇는 인터페이스의 역할을 합니다.")
                    .build();

            clubRepository.save(club5);

            Club club6 = Club.builder()
                    .name("SAI")
                    .category(Category.HS)
                    .tag("학술")
                    .picture("")
                    .oneline("SAI는 인공지능에 관심이 있는 학생이면 누구든지 함께 공부할 수 있는 환경을 만들어주는 인공지능 동아리입니다. 코딩 기초부터 논문 리뷰까지 다양한 팀에서 활동이 가능하며 매월 서로 공부한 내용을 발표하는 시간을 갖습니다.")
                    .build();

            clubRepository.save(club6);

            Club club7 = Club.builder()
                    .name("세종투자연합회")
                    .category(Category.HS)
                    .tag("학술")
                    .picture("")
                    .oneline("2004년에 설립된 UIC 소속 교내 금융투자 동아리 세종투자연합회(세투연)입니다. 투자 방향에 따라 팀을 나누어 투자에 대해 공부하며 전문가 초청강연, 금융포럼, 자산운용대회 등 다양한 외부활동과 공모전에 참여하고 있습니다.")
                    .build();

            clubRepository.save(club7);

            Club club8 = Club.builder()
                    .name("아롬")
                    .category(Category.HS)
                    .tag("학술")
                    .picture("")
                    .oneline("아롬(ALOM)은 Alpha 와 Omega의 합성어로 앱 개발의 시작부터 끝까지 함께하자는 취지에서 설립된 중앙 학술 앱 개발 동아리입니다. 멘토링부터 프로젝트까지 앱 개발과 관련된 다양한 활동을 진행하고 있습니다.")
                    .build();

            clubRepository.save(club8);

            Club club9 = Club.builder()
                    .name("유마프랜")
                    .category(Category.HS)
                    .tag("학술")
                    .picture("")
                    .oneline("유마프랜은 2009년 설립된 세종대학교 마케팅 중앙동아리입니다. 공대생도 누구나 쉽고 재미있게 마케팅을 경험할 수 있게 하는 것이 모토입니다. 팀을 꾸려 공모전에 도전하거나 자체 공모전, 스터디를 통해 관련 경험도 쌓으며 친목을 도모할 수 있습니다.")
                    .build();

            clubRepository.save(club9);

            Club club10 = Club.builder()
                    .name("UNSA")
                    .category(Category.HS)
                    .tag("학술")
                    .picture("")
                    .oneline("UNSA(유엔한국학생협회)는 전국 10여개 대학교의 동아리로 조직된 유엔한국협회의 산하단체입니다. 다양한 주제로 진행되는 집회와 연합 세미나를 통해 누구나 시사에 쉽게 관심을 가질 수 있도록 돕고 있습니다.")
                    .build();

            clubRepository.save(club10);
        }
    }
}
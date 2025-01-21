package PokemonGame;

import java.util.*;

import static PokemonGame.PokeDex.PokemonByName;

public class GameLauncher {
    //야생 포켓몬 더미데이터
    private static Pokemon pokemon1 = new Pokemon("WATER", 100, 1, 15, 30, "pokemon1");
    // 1. 야생 포켓몬 더미데이터

    // 2. 트레이너 더미데이터
    private static Trainer trainer1 = new Trainer(true, "넝쿨마을", "trainer1");
    private static Trainer trainer2 = new Trainer(false, "성신시티", "trainer2");
    // 3. 포켓몬사전에 있는 더미데이터
    private static Map<String, Pokemon> PokemonList = new HashMap<>(PokemonByName);
    // 4. 지역 리스트
    private static List<String> Location = new ArrayList<String>();
    static Scanner consoleInput = new Scanner(System.in);

    public static void main(String[] args) {
        Location.add("마름꽃마을");
        Location.add("넝쿨마을");
        Location.add("성신시티");
        Location.add("칠보시티");
        Location.add("구름시티");

        //TODO : 시뮬레이션 시작부분 작성
        System.out.println("""
                ======== 명령 버튼 명세 =======
                
                ======= 보유포켓몬 리스트 ======"""
                 + trainer1.capturedPokemonList.toString() +
                """
                ======= 시뮬레이션 종료 ========
                            exit
                ============================
                """);
        while (true) {
            //TODO : 명령 입력 (메인 클래스를 만들어야하나,?)
            System.out.println("명령을 입력하세요.");
            //Dex 검색
            //보유 포켓몬 검색
            //도시 이동
            //야생포켓몬 공격
            //트레이너간 배틀
            //명령 명세 재출력

            if (consoleInput.equals("exit")) {
                System.out.println("종료합니다.");
                return;
            }

            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            //1) 리턴타입이 자식타입인 EvolvedPokemon 타입 변수에 할당
//        EvolvedPokemon evolvedPokemon1 = new EvolvedPokemon();
//        pokemon1 = evolvedPokemon1;

            //2) evolve()리턴 타입 자체를 다형성 타입으로 핸들링
            //pokemon1 = pokemon1.evolved(); //적의 레벨을 파라미터로.


        }
    }
}

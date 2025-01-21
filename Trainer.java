package PokemonGame;


import java.util.*;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Trainer implements ITrainer, IOceanCrossable {
    //포획 포켓몬 리스트
    List<Pokemon> capturedPokemonList = new ArrayList<>();
    Map<String, Pokemon> capturedPokemonName = new HashMap<>();
    Scanner inputReader = new Scanner(System.in);

    //쳉육관 관장 boolean
    private boolean GymBoss;
    //현재 위치
    private String currentLocation;
    //이름 String
    private String name;
    //성별


    //생성자
    public Trainer(boolean gymBoss,  String currentLocation, String name) {
        GymBoss = gymBoss;
        this.currentLocation = currentLocation;
        this.name = name;
    }

    @Override
    public void hunt(Pokemon wildPokemon) {
        //포켓몬 사냥은 그냥 야생에서 만난 포켓몬 잡는것.
        System.out.println("야생의 '" + wildPokemon + "' 이 나타났다!" );
        int battleOrCaptured = inputReader.nextInt();
        switch (battleOrCaptured) {
            case 1:
                battle(wildPokemon);
                break;
            case 2:
                Pokemon capturedPokemon = capture(wildPokemon);
                if (capturedPokemon != null) {
                    capturedPokemonList.add(capturedPokemon);
                    capturedPokemonName.put(capturedPokemon.getPokemonName(), capturedPokemon);
                }
        }
    }

    @Override
    public Pokemon capture(Pokemon wildPokemon) {
        //확률적 포획성공 (가중치 적용)
        if (((double) wildPokemon.getLV() / 100) > Math.random()) {
            System.out.println("'" + wildPokemon.getPokemonName() + "' 포획에 실패했습니다.");
            return null;
        } else {
            System.out.println("'" + wildPokemon.getPokemonName() + "' 포획에 성공!!");
            return wildPokemon;
        }
    }

    @Override
    public void battle(Pokemon wildPokemon) {
        //포켓몬 getter, setter 호출
        List<Pokemon> myLineUp = this.getCapturedPokemonList();
        //보유한 포켓몬 순서대로 공격
        for (Pokemon pokemon : myLineUp) {
            while ((pokemon.getHP()) != 0 && (wildPokemon.getHP() != 0)){ //드모르간 법칙으로 대체 가능
                pokemon.attack(wildPokemon);
                wildPokemon.attack(pokemon);
            }
        }
        if (wildPokemon.getHP() == 0) {
            System.out.println("트레이너 승리!");
        } else {
            System.out.println("트레이너 패배,,,");
        }
    }

    @Override
    public void battle(Trainer enemyTrainer) {
    }

    @Override
    public Map<String, Pokemon> searchDex(PokeDex.PokeCategory category) {
        return PokeDex.searchPokemon(category);
    }

    @Override
    public Pokemon searchDex(String pokemonName) {
        return PokeDex.searchPokemon(pokemonName);
    }

    @Override
    public void crossable(String tgCity) {
        //TODO : Surf, FLy 포켓몬이랑 메소드 중복.
        // fly의 crossable과 surf 의 crossable 따로 적용
        //물이나 바람속성 포켓몬 소유중일 때만 가능
        //포켓몬의 상태변경하고 이동
        for (Pokemon movable : capturedPokemonList) {
            if (movable.getClass() == FlyPokemon.class) {
                ((FlyPokemon) movable).setFlyStatus(true);
                this.setCurrentLocation(tgCity);
                System.out.println(tgCity + "에 도착했습니다!");
            } else if (movable.getClass() == SurfPokemon.class){
                ((SurfPokemon)movable).setSurfStatus(true);
                this.setCurrentLocation(tgCity);
                System.out.println(tgCity + "에 도착했습니다!");
            }
        }
    }
}

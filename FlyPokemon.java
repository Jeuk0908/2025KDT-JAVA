package PokemonGame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlyPokemon extends Pokemon implements IFlyable, IOceanCrossable {
    //날고있는 상태
    private boolean flyStatus = false;

    //생성자
    public FlyPokemon(String category, int HP, int LV, int AP, int Defence, String pokemonName, boolean flyStatus) {
        super(category, HP, LV, AP, Defence, pokemonName);
        this.flyStatus = flyStatus;
    }

    @Override
    public void fly() {
        //포켓몬 뜬 상태 변환
        if (flyStatus == false) {
            flyStatus = true;
        } else {
            flyStatus = false;
        }
    }


    @Override
    public void crossable(String tgCity) {
        //TODO : Surf, FLy 포켓몬이랑 메소드 중복.
        //fly() 호출해서 띄우고, 현재 위치 변경
        if (flyStatus == false) {
            flyStatus = true;
        }
        System.out.println(tgCity + " 로 날아갑니다.");
        crossable(tgCity);
    }
}

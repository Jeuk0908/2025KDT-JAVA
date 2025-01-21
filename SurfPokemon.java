package PokemonGame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class SurfPokemon extends Pokemon implements ISurfable, IOceanCrossable {
    //바다에 뛰어든 상태
    private boolean surfStatus = false;

    public SurfPokemon(String category, int HP, int LV, int AP, int Defence, String pokemonName, boolean surfStatus) {
        super(category, HP, LV, AP, Defence, pokemonName);
        this.surfStatus = surfStatus;
    }



    @Override
    public void surf() {
        if (surfStatus == false) {
            surfStatus = true;
        } else {
            surfStatus = false;
        }
    }


    @Override
    public void crossable(String tgCity) {
        //TODO : Surf, FLy 포켓몬이랑 메소드 중복.
        //바다에 뛰어든 상태일때만 바다이동 가능
        if (surfStatus == false) {
            surfStatus = true;
        }
        System.out.println(tgCity + " 로 헤엄쳐갑니다.");
        crossable(tgCity);
    }
}

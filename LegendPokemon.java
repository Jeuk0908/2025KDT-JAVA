package PokemonGame;
import lombok.Getter;
public class LegendPokemon extends Pokemon{
    //희소성 위한 singleton 패턴 사용
    //생성자를 private 로 선언

    public LegendPokemon(String category, int HP, int LV, int AP, int Defence, String pokemonName) {
        super(category, HP, LV, AP, Defence, pokemonName);
    }
}

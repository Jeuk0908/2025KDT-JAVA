package PokemonGame;

import lombok.Getter;

class EvolvedPokemon extends Pokemon {
    public EvolvedPokemon(String category, int HP, int LV, int AP, int Defence, String pokemonName) {
        super(category, HP, LV, AP, Defence, pokemonName);
    }
}

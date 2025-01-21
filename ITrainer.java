package PokemonGame;

import java.util.Map;

public interface ITrainer {

    void hunt(Pokemon wildPokemon);

    Pokemon capture(Pokemon wildPokemon); //야생의 포켓몬

    void battle(Trainer enemyTrainer);

    void battle(Pokemon wildPokemon);

//    Map<String, Pokemon> searchDex(); //검색하면 다 리턴하기

    Map<String, Pokemon> searchDex(PokeDex.PokeCategory category);

    Pokemon searchDex(String pokemonName);
}

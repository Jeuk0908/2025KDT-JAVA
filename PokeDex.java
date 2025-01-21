package PokemonGame;

import java.util.HashMap;
import java.util.Map;

public class PokeDex {

    public static Map<String, Pokemon> PokemonByName = new HashMap<>();
    public static Map<PokeCategory, Map<String, Pokemon>> PokemonByCategory = new HashMap<>();
    //도감
    //포켓몬 도감
    public enum PokeCategory{WATER, FIRE, EARTH, ELECTRIC, BUG, NORMAL, LEGENDARY, MYSTIC, AIR }

    static {
        for (PokeCategory Category : PokeCategory.values()) {
            PokemonByCategory.put(Category, new HashMap<>());
        }
        //Dex 더미데이터 생성
        Pokemon p1 = new Pokemon("WATER", 100,1, 20,20, "p1");
        Pokemon p2 = new Pokemon("FIRE", 100,1, 20,20, "p2");
        Pokemon p3 = new Pokemon("EARTH", 100,1, 20, 20, "p3");
        MysticPokemon p4 = new MysticPokemon("EARTH", 300,1, 60, 70, "p4");
        MysticPokemon p5 = new MysticPokemon("FIRE", 300,1, 70, 60, "p5");
        FlyPokemon p6 = new FlyPokemon("AIR", 100, 1, 20, 20, "p6", false);

        //포켓몬 더미데이터 리스트화
        PokemonByName.put("p1", p1);
        PokemonByCategory.get(PokeCategory.WATER).put(p1.getPokemonName(), p1);
        PokemonByName.put("p2", p2);
        PokemonByCategory.get(PokeCategory.WATER).put(p2.getPokemonName(), p2);
        PokemonByName.put("p3", p3);
        PokemonByCategory.get(PokeCategory.WATER).put(p3.getPokemonName(), p3);
        PokemonByName.put("p4", p4);
        PokemonByCategory.get(PokeCategory.WATER).put(p4.getPokemonName(), p4);
        PokemonByName.put("p5", p5);
        PokemonByCategory.get(PokeCategory.WATER).put(p5.getPokemonName(), p5);
        PokemonByName.put("p6", p6);
        PokemonByCategory.get(PokeCategory.WATER).put(p6.getPokemonName(), p6);
    }

    //이름으로 검색
    public static Pokemon searchPokemon(String name) {
        return PokemonByName.get(name);
    }

    //속성 검색?
    public static Map<String, Pokemon> searchPokemon(PokeCategory category) {
        return PokemonByCategory.get(category);
    }



}

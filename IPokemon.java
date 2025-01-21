package PokemonGame;

public interface IPokemon {


    //메소드
    //attack
    public void attack(Pokemon tgPokemon); //공경 대상 지정 필요

    //flee
    public void flee(Pokemon enemyPokemon);  //상대가 레벨 더 높으면 잘 안도망쳐짐

    //evolved
    public EvolvedPokemon evolve(String pokemonName); //진화 조건

    //향후 오버로딩 가능

    //recovery
}

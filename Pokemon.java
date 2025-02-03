package PokemonGame;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

import static PokemonGame.PokeDex.PokemonByName;


@Getter
@Setter
public class Pokemon implements IPokemon {
    //
    private Map<String, Pokemon> pokemonList = new HashMap<>(PokemonByName);
    //속성
    private String category;
    //체력 int
    private int HP;
    //레벨
    private int LV;
    //공격력 (레벨에 따라 영향)
    private int AP;
    //방어력
    private int Defence;
    //이름
    private String pokemonName;

    public int setCategory(String category) {
        this.category = category;
        return 0;
    }


    //생성자
    public Pokemon(String category, int HP, int LV, int AP, int Defence, String pokemonName) {
        this.category = category;
        this.HP = HP;
        this.LV = LV;
        this.AP = AP;
        this.Defence = Defence;
        this.pokemonName = pokemonName;
    }

    @Override
    public void attack(Pokemon tgPokemon) {
        // 적 방어력 고려한 데미지 계산
        // (AP / 적Defence) * AP = 데미지(소수점 제외)
        tgPokemon.setHP((this.getHP()/ tgPokemon.getDefence()) * this.getAP());
    }

    @Override
    public void flee(Pokemon enemyPokemon) {
        //결과출력
        //TODO : 적 레벨에 다른 도망 성공 확률 변화 (확률로 구현 예정)
        int enemyLv = enemyPokemon.getLV();
        int myPokemonLv = this.getLV();
        if (enemyLv > myPokemonLv) {
            System.out.println("도망치는데 실패했습니다.");
            attack(enemyPokemon);
        } else {
            System.out.println("도망치는데 성공했습니다!");
        }
    }

    @Override
    public EvolvedPokemon evolve(String pokemonName) {
        Pokemon tgPokemon = pokemonList.get(pokemonName);
        //TODO : 진화 조건 명시, 구현 (진화조건은 뭘로??)

        //체력 증가
        int newHP = this.getHP() + 5;
        //레벨변겅 this.setters()
        int newLV = this.getLV() + 1;
        //공격력 증가 this.setters()
        int newAP = this.getAP() + 3;
        //방어력 증가 this.setters()(0.3배수)
        int newDefence = (int) Math.round(this.getDefence() * 1.3);
        String newPokemonName = pokemonName + " LV." + newLV;
        //TODO : 진화되었으니 새 객체 생성 후 리턴, 보유리스트에서 삭제, Dex에 업데이트
        EvolvedPokemon p1 = new EvolvedPokemon(
                this.getCategory(),
                newHP,
                newLV,
                newAP,
                newDefence,
                newPokemonName
        );
        //TODO : 리턴값 이거 맞나?
        return p1;
    }

}

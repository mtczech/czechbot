package data_classes;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pokemon_deserializers.PokemonTeamDataDeserializer;
import utility_classes.PokemonGameData;
import utility_classes.PokemonTemplate;

import java.util.ArrayList;

@JsonDeserialize(using = PokemonTeamDataDeserializer.class)
public class Pokemon {

    //TODO: Implement system for recording boosts
    public Pokemon() {

    }

    public Pokemon(PokemonTemplate speciesTemplate) {
        speciesName = speciesTemplate.getSpeciesName();
        baseAttack = speciesTemplate.getAtk();
        baseDefense = speciesTemplate.getDef();
        baseSpecialAttack = speciesTemplate.getSpa();
        baseSpecialDefense = speciesTemplate.getSpd();
        baseSpeed = speciesTemplate.getSpe();
        types = speciesTemplate.getTypes();
    }

    //Function for calculation of a Pokemon's stats
    public int calculateNonHPStat(int baseStat, int level) {
        int EV_RANDOM_BATTLE_COUNT = 85;
        int IV_RANDOM_BATTLE_COUNT = 31;
        int statTotal = ((2 * baseStat) + EV_RANDOM_BATTLE_COUNT + (int)Math.floor(IV_RANDOM_BATTLE_COUNT * 0.25));
        double levelMultiplier = level / 100;
        int secondStat = (int)Math.floor(levelMultiplier * statTotal);
        return secondStat + 5;
    }

    public int calculateHP(int baseStat, int level) {
        //Fuck Shedinja, all my homies hate Shedinja
        if (baseStat == 1) {
            return 1;
        }
        int EV_RANDOM_BATTLE_COUNT = 85;
        int IV_RANDOM_BATTLE_COUNT = 31;
        int statTotal = ((2 * baseStat) + EV_RANDOM_BATTLE_COUNT + (int)Math.floor(IV_RANDOM_BATTLE_COUNT * 0.25));
        double levelMultiplier = level / 100;
        int secondStat = (int)Math.floor(levelMultiplier * statTotal);
        return secondStat + level + 10;
    }

    //Name of the pokemon
    public String speciesName;

    //Amount of HP a pokemon currently has
    private int currentHp;

    //Maximum HP for a Pokemon
    private int hp;

    //Base stats for a Pokemon that final stats are calculated from

    private int baseHp;

    private int baseAttack;

    private int baseDefense;

    private int baseSpecialAttack;

    private int baseSpecialDefense;

    private int baseSpeed;

    //Stat values for a pokemon before applying modifiers

    private int attack;

    private int defense;

    private int specialAttack;

    private int specialDefense;

    private int speed;

    private ArrayList<String> types;

    private ArrayList<Move> moves = new ArrayList<>();

    private int pokemonLevel;

    private boolean isConfused = false;

    private Ailment ailment = Ailment.None;

    private String item;

    public void setSpeciesName(String setSpeciesName) {
        speciesName = setSpeciesName;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setConfused(boolean confused) {
        isConfused = confused;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setMoves(ArrayList<Move> moves) {
        this.moves = moves;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setPokemonLevel(int pokemonLevel) {
        this.pokemonLevel = pokemonLevel;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public void setBaseSpecialAttack(int baseSpecialAttack) {
        this.baseSpecialAttack = baseSpecialAttack;
    }

    public void setBaseSpecialDefense(int baseSpecialDefense) {
        this.baseSpecialDefense = baseSpecialDefense;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public void setBaseHp(int baseHp) {
        this.baseHp = baseHp;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public int getBaseSpecialAttack() {
        return baseSpecialAttack;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public int getBaseSpecialDefense() {
        return baseSpecialDefense;
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }
}

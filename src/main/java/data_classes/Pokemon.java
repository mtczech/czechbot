package data_classes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import decisions_package.DataRetrievalClient;
import pokemon_deserializers.GeneralPokemonDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = GeneralPokemonDeserializer.class)
public class Pokemon {

    public Pokemon() {

    }

    //Name of the pokemon
    private String speciesName;

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

    //TODO: Add enum for status ailment
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

    public void addMove(MoveURLList urls, DataRetrievalClient getter,
                        ObjectMapper mapper, String moveName) throws IOException {
        String url = urls.getUrls().get(moveName);
        String moveJSON = getter.createAndSendGetRequest(url);
        Move addedMove = mapper.readValue(moveJSON, Move.class);
        for (Move m : moves) {
            if (addedMove.getName().equals(m.getName())) {
                return;
            }
        }
        this.moves.add(addedMove);
    }
}

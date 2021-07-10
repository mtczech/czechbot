package data_classes;

import decisions_package.DataRetrievalClient;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon {

    //Amount of HP a pokemon currently has
    private int currentHp;

    //Maximum HP for a Pokemon
    private int hp;

    //Stat values for a pokemon before applying modifiers

    private int attack;

    private int defense;

    private int specialAttack;

    private int specialDefense;

    private int speed;

    private ArrayList<String> types;

    private ArrayList<Move> moves;

    private int pokemonLevel;

}

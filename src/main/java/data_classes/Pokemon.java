package data_classes;

import decisions_package.DataRetrievalClient;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    //Name of the pokemon
    private String speciesName;

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

    private boolean isConfused = false;

    //TODO: Add enum for status ailment

    private String item;
}

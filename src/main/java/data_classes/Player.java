package data_classes;

import java.util.List;

public class Player {

    public Player() { }

    public Player(Pokemon starter) {
        activePokemon = starter;
    }

    public Player(Pokemon starter, List<Pokemon> backups) {
        activePokemon = starter;
        readyPokemon = backups;
    }

    //The pokemon that this player currently has out
    public Pokemon activePokemon;

    //The list of pokemon that a player has known to be available
    public List<Pokemon> readyPokemon;

    //Number of fainted Pokemon, game over if this number is 6
    public int numFaintedPokemon = 0;

    //Various stat boosts, this cannot have an absolute value of greater than 6
    public int attackBoosts = 0;

    public int defenseBoosts = 0;

    public int specialAttackBoosts = 0;

    public int specialDefenseBoosts = 0;

    public int speedBoosts = 0;

    public int accuracyBoosts = 0;

    public int evasionBoosts = 0;

    public int spikeLayers = 0;

    public int toxicSpikeLayers = 0;

    public boolean stealthRock = false;

    public boolean steelsurge = false;

    public boolean vineLash = false;

    public boolean wildfire = false;

    public boolean volcalith = false;

    public boolean cannonade = false;

    public boolean reflect = false;

    public boolean lightScreen = false;

    public boolean auroraVeil = false;

    public boolean leechSeed = false;

    public boolean tailwind = false;
}

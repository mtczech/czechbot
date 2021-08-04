package data_classes;

import java.util.List;

public class BattleState {
    //The pokemon on your side that is currently in the battle
    private Pokemon activePokemon;

    //The pokemon on the other side that is currently in the battle
    private Pokemon enemyPokemon;

    //A list of all Pokemon currently available to the bot
    private List<Pokemon> readyPokemon;

    //A list of all pokemon known to be available to the enemy
    private List<Pokemon> enemyReadyPokemon;
    /**
     * The number of fainted Pokemon you have, for the purposes of a random battle
     * this number is 6 minus the number of pokemon you have that are not fainted
     * (either active or ready)
     */
    private int numFaintedPokemon = 0;

    //The number of fainted Pokemon the opponent has
    private int numOpponentFaintedPokemon = 0;

    //Constructor for a BattleState given the raw data
    public BattleState(Pokemon yourStarter, Pokemon enemyStarter, List<Pokemon> yourReadyPokemon) {
        activePokemon = yourStarter;
        enemyPokemon = enemyStarter;
        enemyReadyPokemon.add(enemyStarter);
        readyPokemon = yourReadyPokemon;
    }

    /**
     * Stat boosts, ranging from +6 to -6, for the user's and opposing Pokemon
     * for stats such as attack, defense, sp. atk, sp. def, speed, evasion, and accuracy.
     */

    private int botAttackBoosts = 0;

    private int botDefenseBoosts = 0;

    private int botSpecialAttackBoosts = 0;

    private int botSpecialDefenseBoosts = 0;

    private int botSpeedBoosts = 0;

    private int botAccuracyBoosts = 0;

    private int botEvasionBoosts = 0;

    private int enemyAttackBoosts = 0;

    private int enemyDefenseBoosts = 0;

    private int enemySpecialAttackBoosts = 0;

    private int enemySpecialDefenseBoosts = 0;

    private int enemySpeedBoosts = 0;

    private int enemyAccuracyBoosts = 0;

    private int enemyEvasionBoosts = 0;
}

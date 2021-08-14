package data_classes;

import java.util.List;

public class BattleState {
    //The pokemon on your side that is currently in the battle
    private Player bot;

    //The pokemon on the other side that is currently in the battle
    private Player enemy;

    //Constructor for a BattleState given the raw data
    public BattleState(Pokemon yourStarter, Pokemon enemyStarter, List<Pokemon> yourReadyPokemon) {
        bot = new Player(yourStarter, yourReadyPokemon);
        enemy = new Player(enemyStarter);
    }

    /**
     * Stat boosts, ranging from +6 to -6, for the user's and opposing Pokemon
     * for stats such as attack, defense, sp. atk, sp. def, speed, evasion, and accuracy.
     */
    //The weather currently on the field
    private Weather weather = Weather.None;

}

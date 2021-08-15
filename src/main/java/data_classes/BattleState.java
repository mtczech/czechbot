package data_classes;

import java.util.List;

public class BattleState {
    //The user's player instance, contains data on the bot
    private Player bot;

    //Contains data on the opponent
    private Player enemy;

    //Constructor for a BattleState given the raw data
    public BattleState(Pokemon yourStarter, Pokemon enemyStarter, List<Pokemon> yourReadyPokemon) {
        bot = new Player(yourStarter, yourReadyPokemon);
        enemy = new Player(enemyStarter);
    }

    //The weather currently on the field
    private Weather weather = Weather.None;

    //The terrain of the field
    private Terrain terrain = Terrain.None;
}

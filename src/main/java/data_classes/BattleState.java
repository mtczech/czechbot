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

    public BattleState(Player you, Player other) {
        bot = you;
        enemy = other;
    }

    public BattleState() {

    }

    //The weather currently on the field
    private Weather weather = Weather.None;

    //The terrain of the field
    private Terrain terrain = Terrain.None;

    public void setBot(Player setBot) {
        bot = setBot;
    }

    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Player getBot() {
        return bot;
    }

    public Player getEnemy() {
        return enemy;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public Weather getWeather() {
        return weather;
    }
}

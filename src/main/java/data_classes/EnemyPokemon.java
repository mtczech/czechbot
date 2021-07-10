package data_classes;

//This class is for a Pokemon that the bot does not control

import com.fasterxml.jackson.databind.ObjectMapper;
import decisions_package.DataRetrievalClient;

import java.io.IOException;
import java.util.Locale;

public class EnemyPokemon extends Pokemon {

    public EnemyPokemon(int level, String speciesName, DataRetrievalClient client,
                        ObjectMapper mapper) throws IOException {
        String pokemonJSON = client.createAndSendGetRequest(
                "https://pokeapi.co/api/v2/pokemon/" + speciesName.toLowerCase(Locale.ROOT));
    }

    public void addMove(String move) {

    }
}

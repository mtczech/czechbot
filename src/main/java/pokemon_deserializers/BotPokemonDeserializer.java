package pokemon_deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import data_classes.BotPokemon;
import data_classes.Pokemon;
import decisions_package.DataRetrievalClient;

import java.io.IOException;
import java.util.*;

@JsonDeserialize(using = GeneralPokemonDeserializer.class)
public class BotPokemonDeserializer extends StdDeserializer<List<BotPokemon>> {

    public DataRetrievalClient dataGetter = new DataRetrievalClient();

    public BotPokemonDeserializer() {
        this(null);
    }

    public BotPokemonDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public List<BotPokemon> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        ObjectMapper pokemonDataTranslator = new ObjectMapper();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        ArrayList<BotPokemon> returnedPokemon = new ArrayList<>();
        for (var pokemon : node.get("side").get("pokemon")) {
            String[] nameAndLevel = pokemon.get("details").asText().split(",");
            String speciesJson = dataGetter.createAndSendGetRequest(
                    "https://pokeapi.co/api/v2/pokemon/" + nameAndLevel[0].toLowerCase(Locale.ROOT));
            Pokemon newPokemon = pokemonDataTranslator.readValue(speciesJson, Pokemon.class);
            newPokemon.setAttack(pokemon.at("stats").at("atk").asInt());
            newPokemon.setDefense(pokemon.at("stats").at("def").asInt());
            newPokemon.setSpecialAttack(pokemon.at("stats").at("spa").asInt());
            newPokemon.setSpecialDefense(pokemon.at("stats").at("spd").asInt());
            newPokemon.setSpeed(pokemon.at("stats").at("spe").asInt());
            List<String> moves = new LinkedList<>();
            for (var move : pokemon.at("moves")) {
                moves.add(move.asText());
            }
        }
        return null;
    }
}

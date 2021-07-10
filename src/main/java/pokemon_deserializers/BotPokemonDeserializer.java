package pokemon_deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import data_classes.BotPokemon;
import data_classes.Pokemon;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BotPokemonDeserializer extends StdDeserializer<Pokemon> {

    public BotPokemonDeserializer() {
        this(null);
    }

    public BotPokemonDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Pokemon deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        for (var pokemon : node.get("side").get("pokemon")) {
            HashMap<String, Integer> finalStats = new HashMap<>();
            finalStats.put("attack", pokemon.at("stats").at("atk").asInt());
            finalStats.put("defense", pokemon.at("stats").at("def").asInt());
            finalStats.put("specialAttack", pokemon.at("stats").at("spa").asInt());
            finalStats.put("specialDefense", pokemon.at("stats").at("spd").asInt());
            finalStats.put("speed", pokemon.at("stats").at("spe").asInt());
            List<String> moves = new LinkedList<>();
            for (var move : pokemon.at("moves")) {
                moves.add(move.asText());
            }
        }
    }
}

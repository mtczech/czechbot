package pokemon_deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import data_classes.Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;

public class GeneralPokemonDeserializer extends StdDeserializer<Pokemon> {
    public GeneralPokemonDeserializer() {
        this(null);
    }

    protected GeneralPokemonDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Pokemon deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Pokemon createdPokemon = new Pokemon();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        createdPokemon.setSpeciesName(node.get("name").asText().toLowerCase(Locale.ROOT));
        HashMap<String, Integer> baseStats = new HashMap<>();
        for (var stat : node.get("stats")) {
            baseStats.put(stat.get("stat").get("name").textValue(), stat.get("base_stat").asInt());
        }
        for (String statName : baseStats.keySet()) {
            if (statName.equals("hp")) {
                createdPokemon.setBaseHp(baseStats.get(statName));
            } else if (statName.equals("attack")) {
                createdPokemon.setBaseAttack(baseStats.get(statName));
            } else if (statName.equals("defense")) {
                createdPokemon.setBaseDefense(baseStats.get(statName));
            } else if (statName.equals("special-attack")) {
                createdPokemon.setBaseSpecialAttack(baseStats.get(statName));
            } else if (statName.equals("special-defense")) {
                createdPokemon.setBaseSpecialDefense(baseStats.get(statName));
            } else if (statName.equals("speed")) {
                createdPokemon.setBaseSpeed(baseStats.get(statName));
            }
        }
        ArrayList<String> types = new ArrayList<>();
        for (var type : node.get("types")) {
            types.add(type.get("type").get("name").asText());
        }
        createdPokemon.setTypes(types);
        return createdPokemon;
    }
}

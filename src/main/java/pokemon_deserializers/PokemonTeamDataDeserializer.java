package pokemon_deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import utility_classes.PokemonGameData;
import utility_classes.PokemonGameDataTeam;

import java.io.IOException;
import java.util.LinkedList;

public class PokemonTeamDataDeserializer extends StdDeserializer<PokemonGameDataTeam> {
    public PokemonTeamDataDeserializer() {
        this(null);
    }

    protected PokemonTeamDataDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public PokemonGameDataTeam deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        PokemonGameDataTeam returned = new PokemonGameDataTeam();
        LinkedList<PokemonGameData> l = new LinkedList<>();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        for (var datum : node.get("side").get("pokemon")) {
            PokemonGameData current = new PokemonGameData();
            String nameAndLevel = datum.get("details").asText();
            String[] nAndL = nameAndLevel.split(",");
            current.speciesName = nAndL[0];
            if (nAndL[1].equalsIgnoreCase(" M") || nAndL[1].equalsIgnoreCase(" F")) {
                current.level = 100;
            } else {
                current.level = Integer.valueOf(nAndL[1].replace(" L", ""));
            }
            String[] startingHealth = datum.get("condition").asText().split("/");
            current.hp = Integer.valueOf(startingHealth[1]);
            current.isActive = datum.get("active").asBoolean();
            current.atk = datum.get("stats").get("atk").asInt();
            current.def = datum.get("stats").get("def").asInt();
            current.spa = datum.get("stats").get("spa").asInt();
            current.spd = datum.get("stats").get("spd").asInt();
            current.spe = datum.get("stats").get("spe").asInt();
            current.item = datum.get("item").asText();
            l.add(current);
        }
        returned.dataList = l;
        return returned;
    }
}

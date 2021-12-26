package pokemon_deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import data_classes.BattleState;
import data_classes.Pokemon;
import utility_classes.PokemonTemplate;
import utility_classes.PokemonTemplateHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PokemonTemplateDeserializer extends StdDeserializer<PokemonTemplateHolder> {
    public PokemonTemplateDeserializer() {this(null);}

    protected PokemonTemplateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public PokemonTemplateHolder deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        PokemonTemplateHolder h = new PokemonTemplateHolder();
        List<PokemonTemplate> t = new ArrayList<>();
        for (Iterator<String> it = node.fieldNames(); it.hasNext(); ) {
            String key = it.next();
            PokemonTemplate p = new PokemonTemplate();
            p.setDef(node.get(key).get("baseStats").get("def").asInt());
            p.setAtk(node.get(key).get("baseStats").get("atk").asInt());
            p.setSpa(node.get(key).get("baseStats").get("spa").asInt());
            p.setSpd(node.get(key).get("baseStats").get("spd").asInt());
            p.setSpe(node.get(key).get("baseStats").get("spe").asInt());
            p.setHp(node.get(key).get("baseStats").get("hp").asInt());
            ArrayList<String> type = new ArrayList<>();
            for (var v : node.get(key).get("types")) {
                type.add(v.asText());
            }
            p.setTypes(type);
            p.setSpeciesName(node.get(key).get("name").asText());
            t.add(p);
        }
        h.setTemplates(t);
        h.createPokemonMap();
        return h;
    }
}

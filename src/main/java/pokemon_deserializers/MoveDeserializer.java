package pokemon_deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import data_classes.Ailment;
import data_classes.Move;

import java.io.IOException;
import java.util.Locale;

public class MoveDeserializer extends StdDeserializer<Move> {
    public MoveDeserializer() {
        this(null);
    }

    protected MoveDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Move deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Move thisMove = new Move();
        thisMove.setName(node.get("name").asText());
        thisMove.setAccuracy(node.get("accuracy").asInt());
        thisMove.setEffectChance(node.get("effect_chance").asInt());
        thisMove.setPower(node.get("power").asInt());
        thisMove.setPriority(node.get("priority").asInt());
        String condition = node.get("meta").get("ailment").get("name").asText();
        setMoveStatusCondition(thisMove, condition);
        if (thisMove.isCanConfuse()) {
            thisMove.setConfusionChance(node.get("meta").get("ailment_chance").asInt());
        }
        thisMove.setDrain(node.get("meta").get("drain").asInt());
        thisMove.setHealing(node.get("meta").get("healing").asInt());
        thisMove.setAilmentChance(node.get("meta").get("ailment_chance").asInt());
        thisMove.setFlinchChance(node.get("meta").get("flinch_chance").asInt());
        thisMove.setStatChance(node.get("meta").get("stat_chance").asInt());
        thisMove.setType(node.get("type").get("name").asText());
        return thisMove;
    }

    private void setMoveStatusCondition(Move move, String condition) {
        if (condition == "confusion") {
            move.setCanConfuse(true);
        } else if (condition == "paralysis") {
            move.setAilmentName(Ailment.Paralysis);
        } else if (condition == "sleep") {
            move.setAilmentName(Ailment.Sleep);
        } else if (condition == "burn") {
            move.setAilmentName(Ailment.Burn);
        } else if (condition == "freeze") {
            move.setAilmentName(Ailment.Freeze);
        } else if (condition == "poison") {
            move.setAilmentName(Ailment.Poison);
        } else if (move.getName() == "toxic") {
            move.setAilmentName(Ailment.ToxicPoison);
        }
    }
}

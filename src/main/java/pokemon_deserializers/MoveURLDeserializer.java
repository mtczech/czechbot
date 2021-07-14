package pokemon_deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import data_classes.Move;
import data_classes.MoveURLList;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

public class MoveURLDeserializer extends StdDeserializer<MoveURLList> {

    public MoveURLDeserializer() {
        this(null);
    }

    protected MoveURLDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public MoveURLList deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        MoveURLList list = new MoveURLList();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        HashMap<String, String> urls = new HashMap<>();
        for (var move : node) {
            String inputMoveId = move.get("name").textValue().replace("-", "");
            inputMoveId = inputMoveId.toLowerCase(Locale.ROOT);
            urls.put(inputMoveId, move.get("url").textValue());
        }
        list.setUrls(urls);
        return list;
    }
}

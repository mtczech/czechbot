package pokemon_deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import data_classes.Move;

import java.io.IOException;

public class MoveDeserializer extends StdDeserializer<Move> {
    public MoveDeserializer() {
        this(null);
    }

    protected MoveDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Move deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return null;
    }
}

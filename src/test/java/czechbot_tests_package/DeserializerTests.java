package czechbot_tests_package;

import com.fasterxml.jackson.databind.ObjectMapper;
import data_classes.Pokemon;
import decisions_package.DataRetrievalClient;
import org.junit.Before;
import org.junit.Test;
import pokemon_deserializers.GeneralPokemonDeserializer;

import static org.junit.Assert.*;

import java.io.IOException;

public class DeserializerTests {

    String rattataJSON;

    DataRetrievalClient dataGetter = new DataRetrievalClient();

    Pokemon rattata;

    @Before
    public void setUp() throws IOException {
        rattataJSON = dataGetter.createAndSendGetRequest("https://pokeapi.co/api/v2/pokemon/rattata");
        rattata = new ObjectMapper().readValue(rattataJSON, Pokemon.class);
    }

    @Test
    public void sanityCheck() throws IOException {

    }

    @Test
    public void checkBaseStats() {
        assertEquals(rattata.getBaseAttack(), 56);
        assertEquals(rattata.getBaseHp(), 30);
    }
}

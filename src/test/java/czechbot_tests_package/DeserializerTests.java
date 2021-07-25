package czechbot_tests_package;

import android.os.SystemPropertiesProto;
import com.fasterxml.jackson.databind.ObjectMapper;
import data_classes.Move;
import data_classes.Pokemon;
import decisions_package.DataRetrievalClient;
import decisions_package.DecisionEngine;
import org.junit.Before;
import org.junit.Test;
import pokemon_deserializers.GeneralPokemonDeserializer;

import static org.junit.Assert.*;

import java.io.IOException;

public class DeserializerTests {

    String rattataJSON;

    DataRetrievalClient dataGetter = new DataRetrievalClient();

    Pokemon rattata;

    DecisionEngine engine;

    @Before
    public void setUp() throws IOException {
        rattataJSON = dataGetter.createAndSendGetRequest("https://pokeapi.co/api/v2/pokemon/rattata");
        rattata = new ObjectMapper().readValue(rattataJSON, Pokemon.class);
        engine = new DecisionEngine();
    }

    @Test
    public void sanityCheck() throws IOException {

    }

    /**
     * Test for checking that the base stats of a pokemon are correct
     */

    @Test
    public void checkBaseStats() {
        assertEquals(rattata.getBaseAttack(), 56);
        assertEquals(rattata.getBaseHp(), 30);
    }

    @Test
    public void checkMoveToURLMap() {
        assertEquals(engine.getMovesToURLs().getUrls().get("sunsteelstrike"),
                "https://pokeapi.co/api/v2/move/713/");
    }

    @Test
    public void checkBadMoveName() {
        String badName = engine.getMovesToURLs().getUrls().get("tombstoner");
        System.out.println(badName);
    }

    @Test
    public void checkMoveCreator() throws IOException {
        Move fireBlast = engine.moveDeserializeFunction("fireblast");
        assertEquals(fireBlast.getAccuracy(), 85);
        assertEquals(fireBlast.getType(), "fire");
        assertEquals(fireBlast.getAilmentChance(), 10);
    }
    /**
     * Check that a bad move cannot be created
     */
    @Test
    public void createBadMove() throws IOException {
        Move badMove = engine.moveDeserializeFunction("tombstoner");
    }
    /**
     * Check that the same move cannot be added to the same Pokemon twice
     */
    @Test
    public void doNotAddMoveTwice() throws IOException {
        engine.addMoveToPokemon(rattata, "bite");
        engine.addMoveToPokemon(rattata, "bite");
        assertEquals(rattata.getMoves().size(), 1);
    }
}

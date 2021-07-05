package czechbot_tests_package;

import decisions_package.DecisionEngine;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class DataHolderTests {
    /**
     * Check to see the stats of each Pokemon change when stat changes are applied
     */
    @Test
    public void applyStatChanges() {

    }
    /**
     * Check to see that Pokemon can be removed from the list of ready pokemon
     * upon fainting
     */
    @Test
    public void removeFaintedPokemon() {

    }
    /**
     * Check to see stat changes are reset when a pokemon switches out
     */
    @Test
    public void resetStatChanges() {

    }
    /**
     * Check to see type matrix has the correct number of types
     */
    @Test
    public void checkTypeMatrixSize() throws IOException {
        DecisionEngine engine = new DecisionEngine();
        assertEquals(engine.getTypeMatchups().size(), 18);
    }
}

package czechbot_tests_package;

import decisions_package.DecisionEngine;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class DataHolderTests {

    private DecisionEngine engine;

    /**
     * Setting up a DecisionEngine class that has built in type matrix
     */
    @Before
    public void setUp() throws IOException {
        engine = new DecisionEngine();
    }
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
    public void checkTypeMatrixSize() {
        assertEquals(engine.getTypeMatchups().size(), 18);
    }
    /**
     * Check to see type matrix has loaded the type matchups correctly
     * This is for the next three tests, for immunities, 0.5x matchups, and 2x matchups
     */
    @Test
    public void checkTypeImmunity() {
        assertTrue(engine.findDamageMultiplier("normal", "gHoSt") == 0);
    }

    @Test
    public void checkTypeResistance() {
        assertTrue(engine.findDamageMultiplier("ROCK", "GROUND") == 0.5);
    }

    @Test
    public void checkTypeWeakness() {
        assertTrue(engine.findDamageMultiplier("DaRK", "Psychic") == 2);
    }
    /**
     * Check to see damage calculation is correct
     */
    @Test
    public void checkDamageCalculation() {

    }
    /**
     * Check to see burns decrease a Pokemon's attack stat
     */
    @Test
    public void doBurnsDropAttack() {

    }
    /**
     * Test that a pokemon's stat boosts cannot go above plus or minus 6
     */
    @Test
    public void statChangeCaps() {

    }
    /**
     * Test that Porygon2 can be looked up
     */
    @Test
    public void checkForPorygon2() {

    }
    /**
     * Test that Alolan and Galarian forms can be looked up
     */
    @Test
    public void checkForAlternateForms() {

    }
}

package czechbot_tests_package;

import data_classes.Pokemon;
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
     * Test if paralysis drops Speed
     */
    @Test
    public void doesParalysisDropSpeed() {

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
    /**
     * Test that the addMove function works properly
     */
    @Test
    public void checkAddMove() throws IOException {
        Pokemon poke = new Pokemon();
        //poke.addMove(engine.getMovesToURLs(), engine.getClient(), engine.getMapper(), "supersonic");
        assertEquals(poke.getMoves().get(0).getAccuracy(), 55);
        assertEquals(poke.getMoves().size(), 1);
    }
    /**
     * Test that the addMove function cannot add duplicate moves
     */
    @Test
    public void checkForNoDuplicateMoves() throws IOException {
        Pokemon poke = new Pokemon();
        //poke.addMove(engine.getMovesToURLs(), engine.getClient(), engine.getMapper(), "supersonic");
        //poke.addMove(engine.getMovesToURLs(), engine.getClient(), engine.getMapper(), "supersonic");
        assertEquals(poke.getMoves().size(), 1);
    }
    /**
     * Test that Gigantamax moves can only be predicted when in Gigantamax form
     */
    /**
     * Check that residual damage only harms the currently in battle Pokemon
     */
    @Test
    public void checkResidualOnlyCurrentPokemon() {
        
    }

    /**
     * Check to see that there are no duplicate pokemon in a team list
     */
    @Test
    public void checkNoDuplicatePokemon() {

    }
    /**
     * Test that the game does not end when a player has no pokemon left
     * It is possible for a player to have no visible pokemon but the game to still be going
     * E.g. the lead of a player dies but the player has not switched
     */
    @Test
    public void checkPrematureEndGame() {

    }
    /**
     * Test to see if the type names are capitalized the same for move types and engine
     */
    @Test
    public void checkTypeNamesLineUp() {

    }
}

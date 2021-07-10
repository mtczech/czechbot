package czechbot_tests_package;

import decisions_package.ShowdownClient;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConnectionTests {
    ShowdownClient testClient;

    /**
     * Setting everything up for each test
     */
    @Before
    public void setUp() throws URISyntaxException {
        testClient = new ShowdownClient(new URI("ws://sim.smogon.com:8000/showdown/websocket"));
    }
    //Just making sure that I set up JUnit properly
    @Test
    public void sanityCheck() {
        assertEquals(4, 4);
    }

    /**
     * Test that the bot is capable of logging into Showdown
     */
    @Test
    public void isLoginSuccessful() {

    }
    /**
     * Test that the bot can set up an actual battle state
     */
    @Test
    public void setBattleState() {

    }
    /**
     * Test that the bot can set up a CORRECT battle state
     */
    @Test
    public void checkBattleState() {

    }
    /**
     * Test if a response to Showdown can be sent with a move or switch request
     */
    @Test
    public void checkIfRequestValid() {

    }
    /**
     * Test if the program can interpret move data properly
     */
    @Test
    public void checkPokeAPIReception() {

    }
    /**
     * Test if the program terminates when the game is over when the bot wins
     */
    @Test
    public void testEndOfGameWin() {

    }
    /**
     * Same as above but the bot loses
     */
    @Test
    public void testEndOfGameLoss() {

    }
    /**
     * Test that GET requests can be made to PokeAPI for data on a Pokemon
     */
    @Test
    public void getPokemonData() {

    }
    /**
     * Test that GET requests can be made to PokeAPI for data on a move
     */
    @Test
    public void getMoveData() {

    }
}

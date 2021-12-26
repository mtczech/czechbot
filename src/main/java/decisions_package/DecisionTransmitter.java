package decisions_package;

import com.fasterxml.jackson.databind.ObjectMapper;
import utility_classes.AssertionHolder;
import utility_classes.PokemonGameDataTeam;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class DecisionTransmitter {
    //DecisionEngine that does the work of determining which move to use
    private DecisionEngine engine;

    //For sending and receiving HTTP requests of various kinds
    private DataRetrievalClient httpClient;

    //For sending WebSocket instructions to Pokemon Showdown
    private ShowdownClient showdownClient;

    //For receiving JSON instructions from the server
    private ObjectMapper mapper;

    //Assertion holder for receiving the JSON assertion
    private AssertionHolder holder;

    //Scanner for reading commands typed into the console
    private Scanner consoleScanner;

    //Shows whether the user is player 1 or player 2
    private String playerId = "";

    public DecisionTransmitter(String serverURI) throws URISyntaxException, IOException {
        engine = new DecisionEngine();
        httpClient = new DataRetrievalClient();
        showdownClient = new ShowdownClient(new URI(serverURI));
        mapper = new ObjectMapper();
        consoleScanner = new Scanner(System.in);
    }

    /**
     * Initializes a connection between the program and Showdown, also logs in
     */

    public void initialize() throws IOException, InterruptedException {
        showdownClient.connect();
        File privateDataFile = new File("src/main/resources/actually_private_data");
        Scanner tempScanner = new Scanner(privateDataFile);
        LinkedList<String> usernameAndPassword = new LinkedList<>();
        while (tempScanner.hasNextLine()) {
            usernameAndPassword.add(tempScanner.nextLine());
        }
        Thread.sleep(2000);
        String outputJSON = httpClient.createAndSendPostRequest("http://play.pokemonshowdown.com/action.php",
                "act=login&name=" + usernameAndPassword.get(0) + "&pass="
                        + usernameAndPassword.get(1) + "&challstr=" + showdownClient.getChallstr());
        outputJSON = outputJSON.replaceAll("]", "");
        System.out.println(outputJSON);
        holder = mapper.readValue(outputJSON, AssertionHolder.class);
        showdownClient.send("|/trn " + usernameAndPassword.get(0) + ",14," + holder.getAssertion());
        startRandomBattle();
    }

    /**
     * The bot can only do generation 8 random battles as of right now.
     * This command sets the bot to search for a random battle
     */
    public void startRandomBattle() throws IOException, InterruptedException {
        //Code to start the search for a gen8 random battle
        showdownClient.send("|/utm null");
        showdownClient.send("|/search gen8randombattle");
        engine.setBattleGoing(true);
        playerId = showdownClient.getPlayerId();

        sendBattleMessages();
    }

    /**
     * Simple method of sending a message to Showdown with a move request
     */
    public void sendBattleMessages() throws IOException, InterruptedException {
        while (!showdownClient.getIsRequestPending()) {
            Thread.sleep(500);
        }
        //The request is only received once, it should go here
        //it can get changed thanks to keywords
        if (showdownClient.getIsRequestPending()) {
            PokemonGameDataTeam team = mapper.readValue(showdownClient.getCurrentRequest(), PokemonGameDataTeam.class);
            engine.initializeBattle(team);
        }
        while (engine.getBattleGoing()) {
            Thread.sleep(2000);
            boolean request = showdownClient.getIsRequestPending();
            if (showdownClient.getCurrentRequest().contains("forceSwitch") && request) {
                showdownClient.setRequestSwitch(true);
            } else if (request) {
                showdownClient.setRequestSwitch(false);
            }
            if (request) {
                showdownClient.setRequestPending(false);
                //This is the code that executes the decision making system
                int randomInt = new Random().nextInt();
                int moveIndex = Math.abs(randomInt % 5);
                if (showdownClient.getIsRequestSwitch()) {
                    moveIndex = 0;
                }
                if (moveIndex == 0) {
                    showdownClient.setRequestSwitch(false);
                    showdownClient.send(showdownClient.getBattleRoomId() + "|/switch " + (Math.abs(new Random().nextInt() % 5) + 2));
                    Thread.sleep(1000);
                    if (showdownClient.isError) {
                        showdownClient.setRequestPending(true);
                        showdownClient.setRequestSwitch(true);
                    }
                } else {
                    showdownClient.send(showdownClient.getBattleRoomId() + "|/move " + moveIndex);
                    Thread.sleep(1000);
                    if (showdownClient.isError) {
                        showdownClient.setRequestPending(true);
                    }
                }
            }
        }
    }
}

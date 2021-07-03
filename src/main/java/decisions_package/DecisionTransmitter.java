package decisions_package;

import com.fasterxml.jackson.databind.ObjectMapper;
import data_classes.AssertionHolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
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
        Thread.sleep(3000);
        String outputJSON = httpClient.createAndSendPostRequest("http://play.pokemonshowdown.com/action.php",
                "act=login&name=" + usernameAndPassword.get(0) + "&pass="
                        + usernameAndPassword.get(1) + "&challstr=" + showdownClient.getChallstr());
        outputJSON = outputJSON.replaceAll("]", "");
        System.out.println(outputJSON);
        holder = mapper.readValue(outputJSON, AssertionHolder.class);
        showdownClient.send("|/trn " + "czechbot,14," + holder.getAssertion());
        startRandomBattle();
    }

    /**
     * The bot can only do generation 8 random battles as of right now.
     * This command sets the bot to search for a random battle
     * TODO: Implement call to search for a random battle
     */
    public void startRandomBattle() {
        //Code to start the search for a gen8 random battle
        showdownClient.send("|/utm null");
        showdownClient.send("|/search gen8randombattle");
        engine.setBattleGoing(true);
        sendBattleMessages();
    }

    /**
     * Simple method of sending a message to Showdown with a move request
     */
    public void sendBattleMessages() {
        while (engine.getBattleGoing()) {
            String message = consoleScanner.nextLine();
            showdownClient.send(showdownClient.getBattleRoomId() + "|/" + message);
        }
    }
}

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

    public DecisionTransmitter(String serverURI) throws URISyntaxException, IOException {
        engine = new DecisionEngine();
        httpClient = new DataRetrievalClient();
        showdownClient = new ShowdownClient(new URI(serverURI));
        mapper = new ObjectMapper();
    }

    /**
     * Initializes a connection between the program and Showdown, also logs in
     * @throws FileNotFoundException
     * @throws InterruptedException
     */

    public void initialize() throws IOException {
        showdownClient.connect();
        File privateDataFile = new File("src/main/resources/actually_private_data");
        Scanner scanner = new Scanner(privateDataFile);
        LinkedList<String> usernameAndPassword = new LinkedList<>();
        while (scanner.hasNextLine()) {
            usernameAndPassword.add(scanner.nextLine());
        }
        String outputJSON = httpClient.createAndSendPostRequest("http://play.pokemonshowdown.com/action.php",
                "act=login&name=" + usernameAndPassword.get(0) + "&pass="
                        + usernameAndPassword.get(1) + "&challstr=" + showdownClient.getChallstr());
        outputJSON = outputJSON.replaceAll("]", "");
        System.out.println(outputJSON);
        holder = mapper.readValue(outputJSON, AssertionHolder.class);
        String[] modAssertion = holder.getAssertion().split(";");
        System.out.println(holder.getAssertion());
        showdownClient.send("|/trn " + "czechbot,14," + holder.getAssertion());
    }
}

package decisions_package;

import connections_package.DataRetrievalClient;
import connections_package.ShowdownClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class DecisionTransmitter {
    //DecisionEngine that does the work of determining which move to use
    private DecisionEngine engine;

    //For sending and receiving HTTP requests of various kinds
    private DataRetrievalClient httpClient;

    //For sending WebSocket instructions to Pokemon Showdown
    private ShowdownClient showdownClient;

    public DecisionTransmitter(String serverURI) throws URISyntaxException {
        engine = new DecisionEngine();
        httpClient = new DataRetrievalClient();
        showdownClient = new ShowdownClient(new URI(serverURI));
    }

    /**
     * Initializes a connection between the program and Showdown, also logs in
     * @throws FileNotFoundException
     * @throws InterruptedException
     */

    public void initialize() throws InterruptedException, URISyntaxException, IOException {
        showdownClient.connect();
        File privateDataFile = new File("src/main/resources/private_showdown_data");
        Scanner scanner = new Scanner(privateDataFile);
        LinkedList<String> usernameAndPassword = new LinkedList<>();
        while (scanner.hasNextLine()) {
            usernameAndPassword.add(scanner.nextLine());
        }
        Thread.sleep(3000);
        String outputJSON = httpClient.createAndSendPostRequest("http://play.pokemonshowdown.com/action.php",
                "act=login&name=" + usernameAndPassword.get(0) + "&pass="
                        + usernameAndPassword.get(1) + "&challstr=" + showdownClient.getChallstr());
        System.out.println(outputJSON);
        Thread.sleep(3000);
    }
}

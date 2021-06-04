import connections_package.DataRetrievalClient;
import connections_package.ShowdownClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        //The input URI is the server being connected to, can be changed
        new ShowdownClient(new URI("ws://sim.smogon.com:8000/showdown/websocket")).connect();
    }
}

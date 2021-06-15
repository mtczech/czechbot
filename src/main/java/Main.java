import decisions_package.DecisionTransmitter;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        //The input URI is the server being connected to, can be changed
        new DecisionTransmitter("ws://sim.smogon.com:8000/showdown/websocket").initialize();
    }
}

import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        //The input URI is the server being connected to, can be changed
        new ServerLinker("ws://sim.smogon.com:8000/showdown/websocket");
    }
}

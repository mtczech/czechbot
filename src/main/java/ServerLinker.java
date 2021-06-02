import java.net.URI;
import java.net.URISyntaxException;
import org.java_websocket.client.WebSocketClient;

public class ServerLinker {
    /**
     * Target URI to be connected to
     */
    URI targetURI;
    /**
     * Constructor for a blank ServerLinker
     */
    public ServerLinker(String uri) throws URISyntaxException {
        //Initiates handshake
        targetURI = new URI(uri);
    }
}

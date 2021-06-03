package connections_package;

import java.net.URI;
import java.net.URISyntaxException;

public class ServerLinker {
    /**
     * Target URI to be connected to
     */
    private URI targetURI;
    /**
     * Client receiving information from the Showdown servers
     */
    private ShowdownClient client;

    public ShowdownClient getClient() {
        return client;
    }
    /**
     * Constructor for a blank connections_package.ServerLinker
     */
    public ServerLinker(String uri) throws URISyntaxException {
        targetURI = new URI(uri);
        client = new ShowdownClient(targetURI);
    }
}

package connections_package;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class ShowdownClient extends WebSocketClient {

    /**
     * Scanner so that the connection does not immediately terminate
     */
    Scanner scanner = new Scanner(System.in);

    public ShowdownClient(URI serverUri, Draft draft) {
        super(serverUri, draft);
    }

    public ShowdownClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("Connection Achieved!");
        System.out.println(this.isOpen());
        System.out.println(serverHandshake.getHttpStatusMessage());
        this.sendPing();
    }

    @Override
    public void onMessage(String s) {
        System.out.println(this.isOpen());
        System.out.println(s);
        this.sendPing();
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("Connection terminated");
    }

    @Override
    public void onError(Exception e) {
        System.out.println(e);
    }
}

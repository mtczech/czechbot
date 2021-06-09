package connections_package;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class ShowdownClient extends WebSocketClient {

    public ShowdownClient(URI serverUri, Draft draft) {
        super(serverUri, draft);
    }

    public ShowdownClient(URI serverUri) {
        super(serverUri);
    }

    private String challstr = "";

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("Connection Achieved!");
        System.out.println(this.isOpen());
        System.out.println(serverHandshake.getHttpStatusMessage());
    }

    @Override
    public void onMessage(String s) {
        System.out.println(s);
        System.out.println("new message");
        if (s.contains("|challstr|")) {
            String[] strings = s.split("\\|");
            challstr = strings[3];
        }
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("Connection terminated");
    }

    @Override
    public void onError(Exception e) {
        System.out.println(e);
    }

    public String getChallstr() {
        return challstr;
    }
}

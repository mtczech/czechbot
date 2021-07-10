package decisions_package;

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

    private String battleRoomId = "";

    private boolean isPlayerOne;

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
            challstr = strings[2] + "|" + strings[3];
        }
        if (s.charAt(0) == '>') {
            String[] lines = s.split("\n");
            battleRoomId = lines[0].replaceAll(">", "");
        }
        //TODO: If you are using this with a different username, change <czechbot> to your username
        if (s.contains("|player|p1|czechbot")) {
            isPlayerOne = true;
        } else if (s.contains("|player|p2|czechbot")) {
            isPlayerOne = false;
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

    public String getBattleRoomId() {
        return battleRoomId;
    }

    public boolean getIsPlayerOne() {
        return isPlayerOne;
    }
}

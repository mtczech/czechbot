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

    private String currentRequest;

    private String challstr = "";

    private String battleRoomId = "";

    private String playerId = "";

    private boolean isRequestPending = false;

    private boolean isRequestSwitch = false;

    public boolean isError = false;

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("Connection Achieved!");
        System.out.println(this.isOpen());
        System.out.println(serverHandshake.getHttpStatusMessage());
    }

    @Override
    public void onMessage(String s) {
        System.out.println(s);
        if (s.contains("|challstr|")) {
            challstr = s.replace("|challstr|", "");
        }
        if (s.charAt(0) == '>') {
            String[] lines = s.split("\n");
            battleRoomId = lines[0].replaceAll(">", "");
        }
        //TODO: If you are using this with a different username, change <czechbot> to your username
        if (s.contains("|player|p1|czechbot")) {
            playerId = "p1";
        } else if (s.contains("|player|p2|czechbot")) {
            playerId = "p2";
        }
        if (s.contains("|request|")) {
            if (s.contains("{")) {
                int jsonStart = s.indexOf("{");
                currentRequest = s.substring(jsonStart);
                isRequestPending = true;
                if (currentRequest.contains("forceSwitch") && currentRequest.contains("[true]")) {
                    isRequestSwitch = true;
                } else {
                    isRequestSwitch = false;
                }
            }
        }
        if (s.contains("|error|")) {
            isError = true;
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

    public String getCurrentRequest() { return currentRequest; }

    public String getChallstr() {
        return challstr;
    }

    public String getBattleRoomId() {
        return battleRoomId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public boolean getIsRequestPending() {
        return isRequestPending;
    }

    public boolean getIsRequestSwitch() {
        return isRequestSwitch;
    }

    public void setRequestPending(boolean requestPending) {
        isRequestPending = requestPending;
    }

    public void setRequestSwitch(boolean requestSwitch) {
        isRequestSwitch = requestSwitch;
    }

    //I don't need to be very thorough when checking for JSON, since I
    //am only checking standardized inputs from Showdown
    private boolean checkIfJson(String potentialJSON) {
        if (potentialJSON == "") {
            return false;
        }
        if (potentialJSON.charAt(0) == '{' && potentialJSON.charAt(potentialJSON.length() - 1) == '}') {
            return true;
        }
        return false;
    }
}

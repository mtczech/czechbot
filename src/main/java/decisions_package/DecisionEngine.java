package decisions_package;

import com.fasterxml.jackson.databind.ObjectMapper;
import data_classes.Type;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimerTask;

public class DecisionEngine {
    //JSON reader for loading the types into a type matrix
    private ObjectMapper mapper = new ObjectMapper();

    //Whether or not the engine is managing a battle in progress
    private boolean isBattleGoing = false;

    //Type Matrix instance for calling which types are good against which other types
    private List<Type> typeMatchups = new ArrayList<>();

    public DecisionEngine() throws IOException {
        File rawJSON = new File("src/main/resources/type_matrix.json");
        typeMatchups = mapper.readValue(rawJSON, ArrayList.class);
    }

    public void setBattleGoing(boolean setIsBattleGoing) {
        isBattleGoing = setIsBattleGoing;
    }

    public boolean getBattleGoing() {
        return isBattleGoing;
    }

    public void setTypeMatchups(List<Type> typeMatchups) {
        this.typeMatchups = typeMatchups;
    }

    public List<Type> getTypeMatchups() {
        return typeMatchups;
    }
}

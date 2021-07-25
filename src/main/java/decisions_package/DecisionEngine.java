package decisions_package;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import data_classes.Move;
import data_classes.MoveURLList;
import data_classes.Pokemon;
import data_classes.Type;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DecisionEngine {
    //JSON reader for loading the types into a type matrix
    private ObjectMapper mapper = new ObjectMapper();

    //Whether or not the engine is managing a battle in progress
    private boolean isBattleGoing = false;

    //Type Matrix instance for calling which types are good against which other types
    private List<Type> typeMatchups;

    //DataRetrievalClient for getting JSON about pokemon and moves
    private DataRetrievalClient client = new DataRetrievalClient();

    /**
     * The names of moves according to PokeAPI have hyphens in them,
     * the names of moves according to Showdown do not, so I create a map of move names
     * to URLs where I remove the hyphens so I can look up moves
     */
    private MoveURLList movesToURLs;

    public MoveURLList getMovesToURLs() {
        return movesToURLs;
    }

    public DecisionEngine() throws IOException {
        File typeMatrixJSON = new File("src/main/resources/type_matrix.json");
        typeMatchups = mapper.readValue(typeMatrixJSON, new TypeReference<LinkedList<Type>>(){});
        File moveListJSON = new File("src/main/resources/all_moves.json");
        movesToURLs = mapper.readValue(moveListJSON, MoveURLList.class);
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

    public DataRetrievalClient getClient() {
        return client;
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    /**
     * Helper function for finding the damage dealt from type matchups
     * @param attackingType The type of the move being used
     * @param defendingType The type of the defending pokemon, if the defending pokemon
     *                      has two types, this function is called twice
     * @return
     */

    public double findDamageMultiplier(String attackingType, String defendingType) {
        Type attackMoveType = new Type();
        for (Type current : typeMatchups) {
            if (current.getName().equalsIgnoreCase(attackingType)) {
                attackMoveType = current;
                break;
            }
        }
        for (String type : attackMoveType.getImmunes()) {
            if (defendingType.equalsIgnoreCase(type)) {
                return 0;
            }
        }
        for (String type : attackMoveType.getWeaknesses()) {
            if (defendingType.equalsIgnoreCase(type)) {
                return 0.5;
            }
        }
        for (String type : attackMoveType.getStrengths()) {
            if (defendingType.equalsIgnoreCase(type)) {
                return 2;
            }
        }
        return 1;
    }
    /**
     * Creates a move from the JSON data
     * All moves input here must be in all lower case with no spaces
     */
    public Move moveDeserializeFunction(String moveName) throws IOException {
        String url = movesToURLs.getUrls().get(
                moveName.replaceAll(" ", "").toLowerCase(Locale.ROOT));
        if (url != null) {
            String json = client.createAndSendGetRequest(url);
            Move finishedMove = mapper.readValue(json, Move.class);
            return finishedMove;
        }
        throw new IOException("You should not get to here!" +
                " The input is not a valid move or is improperly formatted");
    }

    /**
     * With this function, a move is added to the given Pokemon
     * The move being created is based on the PokeAPI data for that particular move
     */
    public void addMoveToPokemon(Pokemon pokemon, String moveName) throws IOException {
        String url = movesToURLs.getUrls().get(moveName);
        String moveJSON = client.createAndSendGetRequest(url);
        Move addedMove = mapper.readValue(moveJSON, Move.class);
        for (Move m : pokemon.getMoves()) {
            if (addedMove.getName().equals(m.getName())) {
                return;
            }
        }
        pokemon.getMoves().add(addedMove);
    }
}

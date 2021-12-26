package utility_classes;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pokemon_deserializers.PokemonTeamDataDeserializer;

import java.util.LinkedList;
import java.util.List;

@JsonDeserialize(using = PokemonTeamDataDeserializer.class)
public class PokemonGameDataTeam {
    public List<PokemonGameData> dataList;
}

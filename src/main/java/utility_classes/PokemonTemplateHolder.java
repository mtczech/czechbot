package utility_classes;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pokemon_deserializers.PokemonTemplateDeserializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonDeserialize(using = PokemonTemplateDeserializer.class)
public class PokemonTemplateHolder {
    public PokemonTemplateHolder() {

    }

    private List<PokemonTemplate> templates;

    private Map<String, PokemonTemplate> template_map = new HashMap<>();

    public List<PokemonTemplate> getTemplates() {
        return templates;
    }

    public void setTemplates(List<PokemonTemplate> templates) {
        this.templates = templates;
    }

    public void createPokemonMap() {
        for (PokemonTemplate p : templates) {
            template_map.put(p.getSpeciesName(), p);
        }
    }

    //What to do if improper name is put in as parameter?
    public PokemonTemplate accessTemplate(String speciesName) {
        return template_map.get(speciesName);
    }
}

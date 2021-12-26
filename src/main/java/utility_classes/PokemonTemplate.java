package utility_classes;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pokemon_deserializers.PokemonTemplateDeserializer;

import java.util.ArrayList;

public class PokemonTemplate {
    private String speciesName;

    private int hp;

    private int atk;

    private int def;

    private int spa;

    private int spd;

    private int spe;

    private ArrayList<String> types;

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setSpa(int spa) {
        this.spa = spa;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public void setSpe(int spe) {
        this.spe = spe;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getSpa() {
        return spa;
    }

    public int getSpd() {
        return spd;
    }

    public int getSpe() {
        return spe;
    }
}

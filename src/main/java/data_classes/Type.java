package data_classes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains a type matrix for generation 8 types and how effective they are
 * against other types
 */

public class Type {

    //The name of the type, converted to lowercase for synchronization
    private String name;

    //Types that a move of this type will do no damage to
    private String[] immunes;

    //Types that a move of this type will do not very effective damage to
    private String[] weaknesses;

    //Types that a move of this type will deal super effective damage to
    private String[] strengths;

    public Type() {

    }

    public void setName(String setName) {
        name = setName;
    }

    public String getName() {
        return name;
    }

    public String[] getImmunes() {
        return immunes;
    }

    public String[] getStrengths() {
        return strengths;
    }

    public String[] getWeaknesses() {
        return weaknesses;
    }

    public void setImmunes(String[] immunes) {
        this.immunes = immunes;
    }

    public void setStrengths(String[] strengths) {
        this.strengths = strengths;
    }

    public void setWeaknesses(String[] weaknesses) {
        this.weaknesses = weaknesses;
    }
}

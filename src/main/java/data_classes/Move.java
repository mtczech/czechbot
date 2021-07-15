package data_classes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pokemon_deserializers.MoveDeserializer;

@JsonDeserialize(using = MoveDeserializer.class)
public class Move {

    public Move() {

    }

    //Type of move that this move is (physical, special, status)
    private String categoryName;

    //Type of move that this move is (elemental)
    private String type;

    //Base power of a move, 0 if the move does no damage
    private int power = 0;

    //Accuracy of a move
    private int accuracy;

    //Chance the move will cause its additional effect
    private int effectChance = 0;

    //Name of the move
    private String name;

    //Priority bracket of the move, if one move has higher priority than another it will go first
    private int priority;

    //Whether the move is physical, special, or deals no damage
    private String damageClassName;

    //The ailment the move causes, if any
    private Ailment ailmentName = Ailment.None;

    //Chance the move will cause an ailment
    private int ailmentChance = 0;

    //Amount of HP gained back from this move being used, negative in case of recoil damage
    private int drain = 0;

    //Percentage of the user's HP healed
    private int healing = 0;

    //Chance the opponent will flinch
    private int flinchChance = 0;

    //Chance stats will change on the user or opponent
    private int statChance = 0;

    //Whether or not the move can cause confusion
    private boolean canConfuse = false;

    //Chance of causing confusion
    private int confusionChance = 0;

    //Whether or not a move is disabled by lack of PP, choice item, or something else
    private boolean disabled = false;

    public String getType() {
        return type;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isCanConfuse() {
        return canConfuse;
    }

    public int getConfusionChance() {
        return confusionChance;
    }

    public void setCanConfuse(boolean canConfuse) {
        this.canConfuse = canConfuse;
    }

    public void setConfusionChance(int confusionChance) {
        this.confusionChance = confusionChance;
    }

    public String getName() {
        return name;
    }

    public Ailment getAilmentName() {
        return ailmentName;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getAilmentChance() {
        return ailmentChance;
    }

    public int getEffectChance() {
        return effectChance;
    }

    public int getPower() {
        return power;
    }

    public int getDrain() {
        return drain;
    }

    public int getFlinchChance() {
        return flinchChance;
    }

    public int getPriority() {
        return priority;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getHealing() {
        return healing;
    }

    public String getDamageClassName() {
        return damageClassName;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setAilmentChance(int ailmentChance) {
        this.ailmentChance = ailmentChance;
    }

    public void setAilmentName(Ailment ailmentName) {
        this.ailmentName = ailmentName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDamageClassName(String damageClassName) {
        this.damageClassName = damageClassName;
    }

    public void setDrain(int drain) {
        this.drain = drain;
    }

    public void setEffectChance(int effectChance) {
        this.effectChance = effectChance;
    }

    public int getStatChance() {
        return statChance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setFlinchChance(int flinchChance) {
        this.flinchChance = flinchChance;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }

    public void setStatChance(int statChance) {
        this.statChance = statChance;
    }
}

package data_classes;

public class Move {

    public Move() {

    }
    //Type of move that this move is
    private String categoryName;

    //Base power of a move, 0 if the move does no damage
    private int power;

    //Accuracy of a move
    private int accuracy;

    //Chance the move will cause its additional effect
    private int effectChance;

    //Name of the move
    private String name;

    //Priority bracket of the move, if one move has higher priority than another it will go first
    private int priority;

    //Whether the move is physical, special, or deals no damage
    private String damageClassName;

    //The ailment the move causes, if any
    private Ailment ailmentName;

    //Chance the move will cause an ailment
    private int ailmentChance;

    //Amount of HP gained back from this move being used, negative in case of recoil damage
    private int drain;

    //Percentage of the user's HP healed
    private int healing;

    //Chance the opponent will flinch
    private int flinchChance;

    //Chance stats will change on the user or opponent
    private int statChance;

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

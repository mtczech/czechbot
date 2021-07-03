package decisions_package;

public class DecisionEngine {
    //Whether or not the engine is managing a battle in progress
    private boolean isBattleGoing = false;

    public DecisionEngine() {

    }

    public void setBattleGoing(boolean setIsBattleGoing) {
        isBattleGoing = setIsBattleGoing;
    }

    public boolean getBattleGoing() {
        return isBattleGoing;
    }
}

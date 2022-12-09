package usecase_rolldice;

public class RollDiceInputData {

    boolean confirmRoll;

    public RollDiceInputData(boolean confirmRoll) {
        this.confirmRoll = confirmRoll;
    }

    // Getters and Setters

    public void setConfirmRoll(boolean confirmRoll) {
        this.confirmRoll = confirmRoll;
    }

    public boolean isConfirmRoll() {
        return confirmRoll;
    }
}


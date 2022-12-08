package usecase_advance;

public class AdvanceInputData {
    boolean confirmRoll;
    int diceSum;

    public AdvanceInputData(int diceSum) {
        this.confirmRoll = true;
        this.diceSum = diceSum;
    }

    // Getters and Setters
    public boolean isConfirmRoll() {
        return confirmRoll;
    }

    public int getDiceSum() {
        return diceSum;
    }

    public void setConfirmRoll(boolean confirmRoll) {
        this.confirmRoll = confirmRoll;
    }

    public void setDiceSum(int diceSum) {
        this.diceSum = diceSum;
    }
}

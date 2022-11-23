package AdvanceUseCase;

public class AdvanceInputData {
    boolean confirmRoll;
    int diceSum;

    public AdvanceInputData(int diceSum) {
        this.confirmRoll = true;
        this.diceSum = diceSum;
    }

    public boolean isConfirmRoll() {
        return confirmRoll;
    }
}

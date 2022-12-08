package AdvanceUseCase;

public class AdvanceController {

    private AdvanceInputBoundary inputBoundary;
    int diceSum;

    public AdvanceController(AdvanceInputBoundary inputBoundary, int diceSum) {
        this.inputBoundary = inputBoundary;
        this.diceSum = diceSum;
    }

    public AdvanceController() {
    }

    void performAction() throws Exception {
        AdvanceInputData inputData = new AdvanceInputData(diceSum);
        inputBoundary.performAction(inputData);
    }

    // Getters and Setters

    public AdvanceInputBoundary getInputBoundary() {
        return inputBoundary;
    }

    public int getDiceSum() {
        return diceSum;
    }

    public void setDiceSum(int diceSum) {
        this.diceSum = diceSum;
    }

    public void setInputBoundary(AdvanceInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}
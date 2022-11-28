package AdvanceUseCase;

public class AdvanceController {

    private AdvanceInputBoundary inputBoundary;
    final int diceSum;

    public AdvanceController(AdvanceInputBoundary inputBoundary, int diceSum) {
        this.inputBoundary = inputBoundary;
        this.diceSum = diceSum;
    }

    void create() throws Exception {
        AdvanceInputData inputData = new AdvanceInputData(diceSum);
        inputBoundary.create(inputData);
    }

    // Getters and Setters


    public AdvanceInputBoundary getInputBoundary() {
        return inputBoundary;
    }

    public int getDiceSum() {
        return diceSum;
    }

    public void setInputBoundary(AdvanceInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}
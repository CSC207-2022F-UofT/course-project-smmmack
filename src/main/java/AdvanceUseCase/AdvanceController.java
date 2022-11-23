package AdvanceUseCase;

public class AdvanceController {

    final AdvanceInputBoundary input;
    final int diceSum;

    public AdvanceController(AdvanceInputBoundary input, int diceSum) {
        this.input = input;
        this.diceSum = diceSum;
    }

    void create() throws Exception {
        AdvanceInputData inputData = new AdvanceInputData(diceSum);
        input.create(inputData);
    }



}
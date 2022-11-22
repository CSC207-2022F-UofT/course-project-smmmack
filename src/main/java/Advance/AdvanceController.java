package Advance;

public class AdvanceController {

    final AdvanceInputBoundary input;
    final int diceSum;

    public AdvanceController(AdvanceInputBoundary input, int diceSum) {
        this.input = input;
        this.diceSum = diceSum;
    }

    AdvanceOutputData create() throws Exception {
        AdvanceInputData inputData = new AdvanceInputData(diceSum);
        return input.create(inputData);
    }



}
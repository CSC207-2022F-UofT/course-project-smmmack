package Advance;

public class AdvanceController {
    final AdvanceInputBoundary input;

    public AdvanceController(AdvanceInputBoundary input) {
        this.input = input;
    }

    AdvanceOutputData create(String decision){
        AdvanceInputData inputData = new AdvanceInputData(decision);
        return input.create(inputData);
    }

}
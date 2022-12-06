package RollDiceUseCase;

import UseCaseUniversal.CommandPerformer;

public class RollDiceController implements CommandPerformer{

    final RollDiceInputBoundary inputBoundary;
    String userInput;

    public RollDiceController(RollDiceInputBoundary inputBoundary, String userInput) {
        this.inputBoundary = inputBoundary;
        this.userInput = userInput;
    }

    /**
     * Returns if userInput is valid - meaning that the user comfirmed the dice roll.
     * @return If the user input is blank.
     */
    boolean isUserInputValid(){
        return userInput.isBlank();
    }

    void performAction() {
        RollDiceInputData inputData = new RollDiceInputData(isUserInputValid());
    }


    @Override
    public void performCommand(String command) {
        performAction();
    }
}

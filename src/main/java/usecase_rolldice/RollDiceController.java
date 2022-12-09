package usecase_rolldice;

import usecase_universal.CommandPerformer;

public class RollDiceController implements CommandPerformer{

    RollDiceInputBoundary inputBoundary;
    String userInput;

    public RollDiceController(RollDiceInputBoundary inputBoundary, String userInput) {
        this.inputBoundary = inputBoundary;
        this.userInput = userInput;
    }

    public RollDiceController(){

    }

    /**
     * Returns if userInput is valid - meaning that the user comfirmed the dice roll.
     * @return If the user input is blank.
     */
    boolean isUserInputValid(){
        return userInput.isBlank();
    }

    void performAction() throws Exception {
        RollDiceInputData inputData = new RollDiceInputData(isUserInputValid());
        inputBoundary.performAction(inputData);
    }

    @Override
    public void performCommand(String command) throws Exception {
        performAction();
    }

    // Getters and Setters


    public RollDiceInputBoundary getInputBoundary() {
        return inputBoundary;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public void setInputBoundary(RollDiceInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}

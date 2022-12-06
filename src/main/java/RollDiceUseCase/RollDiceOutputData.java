package RollDiceUseCase;

public class RollDiceOutputData {

    String rollDiceMessage;
    boolean isValidInput;

    public RollDiceOutputData( String rollDiceMessage, boolean isValidInput){
        this.rollDiceMessage = rollDiceMessage;
        this.isValidInput = isValidInput;
    }

    // Getters and Setters
    public String getRollDiceMessage() {
        return rollDiceMessage;
    }

    public boolean isValidInput() {
        return isValidInput;
    }

    public void setRollDiceMessage(String rollDiceMessage) {
        this.rollDiceMessage = rollDiceMessage;
    }

    public void setValidInput(boolean validInput) {
        isValidInput = validInput;
    }
}

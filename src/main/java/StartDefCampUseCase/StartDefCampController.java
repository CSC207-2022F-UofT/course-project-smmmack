package StartDefCampUseCase;

import UseCaseUniversal.CommandPerformer;

public class StartDefCampController implements CommandPerformer {
    private StartDefCampInputBoundary inputBoundary;

    public StartDefCampController(StartDefCampInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void performCommand(String command) throws IllegalArgumentException{
        String[] words = command.split("\\s+");
        if (words.length != 2)
            throw new IllegalArgumentException("This command only takes in one parameter");
        if (!words[1].matches("\\d+"))
            throw new IllegalArgumentException("The argument of this command may only be a non-negative integer");
        int playerNum = Integer.parseInt(words[1]);
        StartDefCampInputData inputData = new StartDefCampInputData(playerNum);
        inputBoundary.performAction(inputData);
    }

    //getters

    public StartDefCampInputBoundary getInputBoundary() {
        return inputBoundary;
    }

    //setters

    public void setInputBoundary(StartDefCampInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}

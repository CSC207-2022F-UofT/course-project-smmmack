package StartDefCampUseCase;

import MainEntities.Exceptions.WrongCommandArgumentException;
import UseCaseUniversal.CommandPerformer;

public class StartDefCampController implements CommandPerformer {
    private StartDefCampInputBoundary inputBoundary;

    public StartDefCampController() {

    }

    public StartDefCampController(StartDefCampInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * The command accepted by this controller should be in the following pattern: <br>
     * save_default_campaign [num] <br>
     * num: the number of players
     * @param command the command string (user input)
     */
    public void performCommand(String command) throws Exception {
        String[] words = command.split("\\s+");
        if (words.length != 2)
            throw new WrongCommandArgumentException("This command only takes in one parameter");
        if (!words[1].matches("\\d+"))
            throw new WrongCommandArgumentException("The argument of this command may only be a non-negative integer");
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

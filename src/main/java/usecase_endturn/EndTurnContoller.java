package usecase_endturn;

import exception.WrongCommandArgumentException;
import usecase_universal.CommandPerformer;

public class EndTurnContoller implements CommandPerformer {
    private EndTurnInputBoundary inputBoundary;

    /**
     * The command accepted by this controller should be in the following pattern: <br>
     * end_turn <br>
     * no parameters are accepted
     * @param command the command string (user input)
     */
    @Override
    public void performCommand(String command) throws Exception {
        String[] words = command.split("\\s+");
        if (words.length != 1)
            throw new WrongCommandArgumentException("This command takes in no argument");
        inputBoundary.performAction(new EndTurnInputData());

    }

    public void setInputBoundary(EndTurnInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public EndTurnInputBoundary getInputBoundary() {
        return inputBoundary;
    }
}

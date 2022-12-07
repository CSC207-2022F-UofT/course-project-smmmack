package EndTurnUseCase;

import MainEntities.Exceptions.WrongCommandArgumentException;
import UseCaseUniversal.CommandPerformer;

public class EndTurnContoller implements CommandPerformer {
    private EndTurnInputBoundary inputBoundary;

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

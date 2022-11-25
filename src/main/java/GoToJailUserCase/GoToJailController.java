package GoToJailUserCase;

public class GoToJailController {
    private GoToJailInputBoundary inputBoundary;

    public GoToJailController(GoToJailInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    GoToJailOutputData create (boolean jail) throws Exception {
        GoToJailInputData inputData = new GoToJailInputData(jail);
        return inputBoundary.create(inputData);
    }
    public GoToJailInputBoundary getInput() {
        return inputBoundary;
    }
    public void setInputBoundary(GoToJailInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}

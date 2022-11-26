package GoToJailUserCase;

public class GoToJailController {
    private GoToJailInputBoundary inputBoundary;

    public GoToJailController(GoToJailInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void create(boolean jail) {
        GoToJailInputData inputData = new GoToJailInputData(jail);
        this.inputBoundary.create(inputData);
    }

    public GoToJailInputBoundary getInput() {
        return inputBoundary;
    }
    public void setInputBoundary(GoToJailInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}

package GoToJailUserCase;


public class GoToJailController {
    private GoToJailInputBoundary inputBoundary;

    public GoToJailController(GoToJailInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void performAction() throws Exception {

    }

    public GoToJailInputBoundary getInput() {
        return inputBoundary;
    }
    public void setInputBoundary(GoToJailInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}

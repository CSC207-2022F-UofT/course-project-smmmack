package GoToJailUserCase;

public class GoToJailPresenter implements GoToJailOutputBoundary{

    @Override
    public void create(GoToJailOutputData outputData) {
        String message = outputData.getMessage();
        // Update the view model to add the output message to the command lines
    }
}


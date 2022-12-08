package jail_test;

import GoToJailUserCase.GoToJailOutputBoundary;
import GoToJailUserCase.GoToJailOutputData;

/**
 * Presenter class for GoToJailTest so that the View iwll not need to be updated each test call.
 */
public class GoToJailPresenter implements GoToJailOutputBoundary{

    @Override
    public void performAction(GoToJailOutputData outputData){
        // Void method for advance tests.
    }
}

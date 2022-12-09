package jail_test;

import usecase_gotojail.GoToJailOutputBoundary;
import usecase_gotojail.GoToJailOutputData;

/**
 * Presenter class for GoToJailTest so that the View iwll not need to be updated each test call.
 */
public class GoToJailPresenter implements GoToJailOutputBoundary{

    @Override
    public void performAction(GoToJailOutputData outputData){
        // Void method for advance tests.
    }
}

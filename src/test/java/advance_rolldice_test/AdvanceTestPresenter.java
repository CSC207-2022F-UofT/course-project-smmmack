package advance_rolldice_test;

import usecase_advance.AdvanceOutputBoundary;
import usecase_advance.AdvanceOutputData;

/**
 * Presenter class for AdvanceTest so that the View iwll not need to be updated each test call.
 */
public class AdvanceTestPresenter implements AdvanceOutputBoundary {

    @Override
    public void performAction(AdvanceOutputData outputData){
        // Void method for advance tests.
    }
}

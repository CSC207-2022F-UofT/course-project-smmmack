import AdvanceUseCase.AdvanceOutputBoundary;
import AdvanceUseCase.AdvanceOutputData;

/**
 * Presenter class for AdvanceTest so that the View iwll not need to be updated each test call.
 */
public class AdvanceTestPresenter implements AdvanceOutputBoundary {

    @Override
    public void performAction(AdvanceOutputData outputData){
        // Void method for advance tests.
    }
}

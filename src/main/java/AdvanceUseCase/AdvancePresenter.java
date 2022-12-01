package AdvanceUseCase;

public class AdvancePresenter implements AdvanceOutputBoundary{

    @Override
    public void create(AdvanceOutputData outputData){
        String advanceMessage = outputData.getAdvanceMessage();
        // Update viewmodel to display the advance message after Max's pull request is pushed.
    }

}

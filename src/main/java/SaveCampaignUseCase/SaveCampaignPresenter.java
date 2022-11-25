package SaveCampaignUseCase;

public class SaveCampaignPresenter implements SaveCampaignOutputBoundary{

    @Override
    public void performAction(SaveCampaignOutputData outputData) {
        String outputMessage = outputData.getOutputMessage();
        // Update the view model to add the output message to the command lines
    }
}

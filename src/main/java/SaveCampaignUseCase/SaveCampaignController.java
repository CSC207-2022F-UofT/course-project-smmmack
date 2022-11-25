package SaveCampaignUseCase;

public class SaveCampaignController {
    private SaveCampaignInputBoundary inputBoundary;

    public SaveCampaignController(SaveCampaignInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void performAction(String command) {
        String[] words = command.split("\\s+");
        String address = words[1];
        SaveCampaignInputData inputData = new SaveCampaignInputData(address);
        inputBoundary.performAction(inputData);
    }

    //getters

    public SaveCampaignInputBoundary getInputBoundary() {
        return inputBoundary;
    }

    //setters

    public void setInputBoundary(SaveCampaignInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}

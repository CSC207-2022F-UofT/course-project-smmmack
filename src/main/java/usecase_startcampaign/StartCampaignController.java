package usecase_startcampaign;

public class StartCampaignController {
    private StartCampaignInputBoundary inputBoundary;

    public StartCampaignController() {

    }

    public StartCampaignController(StartCampaignInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void performAction() {
        StartCampaignInputData inputData = new StartCampaignInputData();
        this.inputBoundary.performAction(inputData);
    }

    //getters

    public StartCampaignInputBoundary getInputBoundary() {
        return inputBoundary;
    }

    //setters

    public void setInputBoundary(StartCampaignInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}

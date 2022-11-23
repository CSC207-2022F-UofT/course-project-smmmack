package StartCampaignUseCase;

import MainEntities.Campaign;

public class StartCampaignInteractor implements StartCampaignInputBoundary {

    private Campaign campaign;
    private StartCampaignOutputBoundary outputBoundary;

    public StartCampaignInteractor(Campaign campaign, StartCampaignOutputBoundary outputBoundary) {
        this.campaign = campaign;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void performAction(StartCampaignInputData inputData) {

    }

    //getter

    public Campaign getCampaign() {
        return campaign;
    }

    public StartCampaignOutputBoundary getOutputBoundary() {
        return outputBoundary;
    }

    //setters

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public void setOutputBoundary(StartCampaignOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }
}

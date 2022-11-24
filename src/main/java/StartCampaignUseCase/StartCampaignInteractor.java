package StartCampaignUseCase;

import MainEntities.Campaign;
import MainEntities.CampaignAccess;

public class StartCampaignInteractor implements StartCampaignInputBoundary {

    private CampaignAccess campaignAccess;
    private StartCampaignOutputBoundary outputBoundary;

    public StartCampaignInteractor(CampaignAccess campaignAccess, StartCampaignOutputBoundary outputBoundary) {
        this.campaignAccess = campaignAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void performAction(StartCampaignInputData inputData) {
        //to be implemented
    }

    //getter

    public CampaignAccess getCampaignAccess() {
        return campaignAccess;
    }

    public StartCampaignOutputBoundary getOutputBoundary() {
        return outputBoundary;
    }

    //setters

    public void setCampaignAccess(CampaignAccess campaignAccess) {
        this.campaignAccess = campaignAccess;
    }

    public void setOutputBoundary(StartCampaignOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    //other getters

    public Campaign getCampaign() {
        return campaignAccess.getCampaign();
    }

    //other setters

    public void setCampaign(Campaign campaign) {
        campaignAccess.setCampaign(campaign);
    }
}

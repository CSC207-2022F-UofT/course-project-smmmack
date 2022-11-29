package StartCampaignUseCase;

import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.Player;

public class StartCampaignInteractor implements StartCampaignInputBoundary {

    private CampaignAccess campaignAccess;
    private StartCampaignOutputBoundary outputBoundary;

    public StartCampaignInteractor(CampaignAccess campaignAccess, StartCampaignOutputBoundary outputBoundary) {
        this.campaignAccess = campaignAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void performAction(StartCampaignInputData inputData) {
        String campaignName = inputData.getCampaignName();
        Campaign campaign = campaignAccess.getCampaign();
        Player currPlayer = campaign.getCurrentPlayer();
        String playerName = currPlayer.getName();
        String message = "Starting campaign: " + campaignName + ", player " + playerName + "'s turn.";
        String nextMap = "before_move";
        outputBoundary.performAction(new StartCampaignOutputData(message, nextMap));
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

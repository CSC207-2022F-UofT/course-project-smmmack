package StartDefCampUseCase;

import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.CampaignFactory;
import MainEntities.DefaultCampaignFactory;
import StartCampaignUseCase.StartCampaignInputData;
import StartCampaignUseCase.StartCampaignInputBoundary;

public class StartDefCampInteractor implements StartDefCampInputBoundary {

    private CampaignAccess campaignAccess;
    private StartDefCampOutputBoundary outputBoundary;
    private StartCampaignInputBoundary startCampaignInputBoundary;

    public StartDefCampInteractor(CampaignAccess campaignAccess, StartDefCampOutputBoundary outputBoundary) {
        this.campaignAccess = campaignAccess;
        this.outputBoundary = outputBoundary;
    }

    public StartDefCampInteractor(CampaignAccess campaignAccess,
                                  StartDefCampOutputBoundary outputBoundary,
                                  StartCampaignInputBoundary startCampaignInputBoundary) {
        this.campaignAccess = campaignAccess;
        this.outputBoundary = outputBoundary;
        this.startCampaignInputBoundary = startCampaignInputBoundary;
    }

    @Override
    public void performAction(StartDefCampInputData inputData) {
        //create new campaign and assign it to the campaign access
        int playerNum = inputData.getPlayerNum();
        CampaignFactory factory = new DefaultCampaignFactory(playerNum);
        Campaign campaign = factory.create();
        this.campaignAccess.setCampaign(campaign);

        //create output
        StartDefCampOutputData outputData = new StartDefCampOutputData("New campaign of " + playerNum + "created...");
        outputBoundary.performAction(outputData);

        //call next use case
        StartCampaignInputData startCampaignInputData = new StartCampaignInputData();
        startCampaignInputBoundary.performAction(startCampaignInputData);
    }

    //getters

    public CampaignAccess getCampaignAccess() {
        return campaignAccess;
    }

    public StartDefCampOutputBoundary getOutputBoundary() {
        return outputBoundary;
    }

    public StartCampaignInputBoundary getStartCampaignInputBoundary() {
        return startCampaignInputBoundary;
    }

    //setters

    public void setCampaignAccess(CampaignAccess campaignAccess) {
        this.campaignAccess = campaignAccess;
    }

    public void setOutputBoundary(StartDefCampOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    public void setStartCampaignInputBoundary(StartCampaignInputBoundary startCampaignInputBoundary) {
        this.startCampaignInputBoundary = startCampaignInputBoundary;
    }

    //other getters

    public Campaign getCampaign() {
        return this.campaignAccess.getCampaign();
    }

    //other setters

    public void setCampaign(Campaign campaign) {
        this.campaignAccess.setCampaign(campaign);
    }
}

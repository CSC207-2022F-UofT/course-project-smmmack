package StartCampaignUseCase;

import MainEntities.Campaign;

public class StartCampaignInteractor implements StartCampaignInputBoundary {

    private Campaign campaign;

    @Override
    public void performAction(StartCampaignInputData inputData) {

    }

    //getter

    public Campaign getCampaign() {
        return campaign;
    }

    //setters

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
}

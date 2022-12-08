package EndTurnUseCase;

import MainEntities.Campaign;
import MainEntities.CampaignAccess;

public class EndTurnInteractor implements EndTurnInputBoundary{
    private CampaignAccess campaignAccess;
    private EndTurnOutputBoundary outputBoundary;

    @Override
    public void performAction(EndTurnInputData inputData) {
        Campaign campaign = campaignAccess.getCampaign();
        campaign.incrementCurrPlayerIndex();
        if (campaign.getCurrPlayerIndex() == 0) {
            campaign.incrementRoundCount();
        }
        String message = "Now it's player " + campaign.getCurrentPlayer().getName() + "'s turn. " +
                "(Round count: " + campaign.getRoundCount() + ")";
        outputBoundary.performAction(new EndTurnOutputData(message));
    }

    // setters

    public void setCampaignAccess(CampaignAccess campaignAccess) {
        this.campaignAccess = campaignAccess;
    }

    public void setOutputBoundary(EndTurnOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    //getters

    public CampaignAccess getCampaignAccess() {
        return campaignAccess;
    }

    public EndTurnOutputBoundary getOutputBoundary() {
        return outputBoundary;
    }
}

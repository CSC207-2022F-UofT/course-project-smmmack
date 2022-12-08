package EndTurnUseCase;

import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.Player;

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
        Player player = campaign.getCurrentPlayer();
        if (player.getJailTurn() > 0) {
            String message = "Now it's player " + campaign.getCurrentPlayer().getName() + "'s turn. " +
                    "(Round count: " + campaign.getRoundCount() + ")\n\n" +
                    "You are in jail so you can't move.";
            player.setJailTurn(player.getJailTurn() - 1);
            int playerIndex = campaign.getCurrPlayerIndex();
            int playerJailTurn = player.getJailTurn();
            outputBoundary.performAction(new EndTurnOutputData(message, "after_move",
                    playerIndex, playerJailTurn));
        } else {
            String message = "Now it's player " + campaign.getCurrentPlayer().getName() + "'s turn. " +
                    "(Round count: " + campaign.getRoundCount() + ")";
            int playerIndex = campaign.getCurrPlayerIndex();
            int playerJailTurn = player.getJailTurn();
            outputBoundary.performAction(new EndTurnOutputData(message, "before_move",
                    playerIndex, playerJailTurn));
        }
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

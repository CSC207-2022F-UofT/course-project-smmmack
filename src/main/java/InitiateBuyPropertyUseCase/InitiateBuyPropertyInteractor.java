package InitiateBuyPropertyUseCase;

import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.Player;
import Properties.Property;
import Tiles.PropertyTile;

public class InitiateBuyPropertyInteractor implements InitiateBuyPropertyInputBoundary{
    private InitiateBuyPropertyOutputBoundary output;
    private CampaignAccess campaignAccess;


    public InitiateBuyPropertyInteractor(InitiateBuyPropertyOutputBoundary output,
                                         CampaignAccess campaignAccess){
        this.output = output;
        this.campaignAccess = campaignAccess;

    }

    public InitiateBuyPropertyInteractor(){

    }

    // CampaignAccess Getter & Setter:

    public CampaignAccess getCampaignAccess() {
        return campaignAccess;
    }

    public void setCampaignAccess(CampaignAccess campaignAccess) {
        this.campaignAccess = campaignAccess;
    }

    /**
     *
     * @return Returns true if the player lands on a Property tile,
     *         otherwise returns false.
     */

    public boolean checkLandOnPropertyTile(){
        Campaign campaign = campaignAccess.getCampaign();
        int currPlayerIndex = campaign.getCurrPlayerIndex();
        Player player = campaign.getPlayerAt(currPlayerIndex);
        if(campaign.getTileUnderPlayer(player) instanceof PropertyTile){
            PropertyTile currPropertyTile = (PropertyTile) campaign.getTileUnderPlayer(player);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void performAction(InitiateBuyPropertyInputData initiateBuyPropertyInputData) throws Exception{
        Campaign campaign = campaignAccess.getCampaign();
        Player currPlayer = campaign.getCurrentPlayer();
        PropertyTile currPropertyTile = (PropertyTile) campaign.getTileUnderPlayer(currPlayer);
        Property currProperty = currPropertyTile.getProperty();
        InitiateBuyPropertyOutputData initiateOutputDataQuestion;

        try {
            if (checkLandOnPropertyTile()) {
                // The player lands on a Property Tile; whether the player wants to purchase the
                // landed on property is asked to the player.
                initiateOutputDataQuestion = new InitiateBuyPropertyOutputData("Would you like to " +
                        " purchase " + currProperty.getName() + " for " +
                        currProperty.getPrice() + "?", true);
            } else {
                // The player does not land on a Property Tile; thus no question is asked.
                initiateOutputDataQuestion = new InitiateBuyPropertyOutputData(null,
                        false);
            }

            } catch (Exception exception) {
            initiateOutputDataQuestion = new InitiateBuyPropertyOutputData(null,
                    false);
            output.performAction(initiateOutputDataQuestion);

        }
        output.performAction(initiateOutputDataQuestion);
    }


}

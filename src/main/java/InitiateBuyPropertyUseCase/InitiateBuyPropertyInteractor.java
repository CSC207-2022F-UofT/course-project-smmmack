package InitiateBuyPropertyUseCase;

import ConfirmBuyPropertyUseCase.ConfirmBuyPropertyInputBoundary;
import ConfirmBuyPropertyUseCase.ConfirmBuyPropertyInputData;
import MainEntities.CampaignAccess;
import MainEntities.Player;
import Properties.Property;
import Tiles.PropertyTile;

public class InitiateBuyPropertyInteractor implements InitiateBuyPropertyInputBoundary{
    private final InitiateBuyPropertyOutputBoundary output;
    CampaignAccess campaignAccess;
    ConfirmBuyPropertyInputBoundary confirmBuyPropertyInputBoundary;
    ConfirmBuyPropertyInputData confirmBuyPropertyInputData;
    Player player;
    Property property;


    public InitiateBuyPropertyInteractor(InitiateBuyPropertyOutputBoundary output,
                                         CampaignAccess campaignAccess,
                                         ConfirmBuyPropertyInputBoundary confirmBuyPropertyInputBoundary,
                                         ConfirmBuyPropertyInputData confirmBuyPropertyInputData,
                                         Player player, Property property){
        this.output = output;
        this.campaignAccess = campaignAccess;
        this.confirmBuyPropertyInputBoundary = confirmBuyPropertyInputBoundary;
        this.confirmBuyPropertyInputData = confirmBuyPropertyInputData;
        this.player = player;
        this.property = property;

    }

    /**
     *
     * @return Returns true if the player lands on a Property tile, and refers
     *         to initiateBuyLand() function, otherwise returns false.
     */

    public boolean checkLandOnPropertyTile(){
        int currPlayerIndex = campaignAccess.getCampaign().getCurrPlayerIndex();
        Player player = campaignAccess.getCampaign().getPlayerAt(currPlayerIndex);
        if(campaignAccess.getCampaign().getTileUnderPlayer(player) instanceof PropertyTile){
            PropertyTile currPropertyTile = (PropertyTile) campaignAccess.getCampaign().getTileUnderPlayer(player);
            initiateBuyLand(player, currPropertyTile.getProperty());
            return true;
        } else {
            return false;
        }

    }

    /**
     * References to the Confirm Buy property use case when the property lands on a property tile.
     * The player can either decide to attempt to purchasing the landed on property or not.
     */

    public void initiateBuyLand(Player player, Property property){
        ConfirmBuyPropertyInputData confirmBuyPropertyInputData = new ConfirmBuyPropertyInputData(true);
        if (confirmBuyPropertyInputData.getDecision()) {
            try {
                confirmBuyPropertyInputBoundary.performAction(confirmBuyPropertyInputData);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public void performAction(InitiateBuyPropertyInputData initiateBuyPropertyInputData) throws Exception{
        initiateBuyLand(player, property);
        InitiateBuyPropertyOutputData initiateOutputDataQuestion;

        // The player lands on a Property Tile.

        if (checkLandOnPropertyTile()){
            // The player decides to attempt purchasing the landed on property, when the question is introduced.
            initiateOutputDataQuestion = new InitiateBuyPropertyOutputData("Would you like to " +
                    " purchase " + property.getName() + " for "
                    + property.getPrice() + "?", confirmBuyPropertyInputData.getDecision());
        }

        // The player does not land on a Property Tile.

        else

        {
            initiateOutputDataQuestion = new InitiateBuyPropertyOutputData(null, false);
        }

        output.performAction(initiateOutputDataQuestion);


    }


}

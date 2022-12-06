package InitiateBuyPropertyUseCase;

import ConfirmBuyPropertyUseCase.ConfirmBuyPropertyInputBoundary;
import ConfirmBuyPropertyUseCase.ConfirmBuyPropertyInputData;
import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.Player;
import Properties.Property;
import Tiles.PropertyTile;
import ViewModel.InputMapDictionary;

public class InitiateBuyPropertyInteractor implements InitiateBuyPropertyInputBoundary{
    private final InitiateBuyPropertyOutputBoundary output;
    private final CampaignAccess campaignAccess;
    private final ConfirmBuyPropertyInputBoundary confirmBuyPropertyInputBoundary;
    private final ConfirmBuyPropertyInputData confirmBuyPropertyInputData;


    public InitiateBuyPropertyInteractor(InitiateBuyPropertyOutputBoundary output,
                                         CampaignAccess campaignAccess,
                                         ConfirmBuyPropertyInputBoundary confirmBuyPropertyInputBoundary,
                                         ConfirmBuyPropertyInputData confirmBuyPropertyInputData){
        this.output = output;
        this.campaignAccess = campaignAccess;
        this.confirmBuyPropertyInputBoundary = confirmBuyPropertyInputBoundary;
        this.confirmBuyPropertyInputData = confirmBuyPropertyInputData;

    }

    /**
     *
     * @return Returns true if the player lands on a Property tile, and refers
     *         to initiateBuyLand() function, otherwise returns false.
     */

    public boolean checkLandOnPropertyTile(){
        Campaign campaign = campaignAccess.getCampaign();
        int currPlayerIndex = campaign.getCurrPlayerIndex();
        Player player = campaign.getPlayerAt(currPlayerIndex);
        if(campaign.getTileUnderPlayer(player) instanceof PropertyTile){
            PropertyTile currPropertyTile = (PropertyTile) campaign.getTileUnderPlayer(player);
            initiateBuyLand();
            return true;
        } else {
            return false;
        }

    }

    /**
     * Checks whether the player lands on a property with checkLandOnPropertyTile() function &
     * sets the type of question to be asked. If the player lands on a property tile, question of type
     * 1 is asked whether the player wants to purchase the landed on property or not. If the player does
     * not land on a property tile, question of type 0 is asked, which corresponds to a null question, no
     * question will be asked.
     * @return An integer indicating the type of the question.
     */

    public int initiateBuyLand(){
        int question;
        if (checkLandOnPropertyTile()){
            question = 1;
        } else {
            question = 0;
        } return question;
    }

    @Override
    public void performAction(InitiateBuyPropertyInputData initiateBuyPropertyInputData) throws Exception{
        int question = initiateBuyLand();
        Campaign campaign = campaignAccess.getCampaign();
        Player currPlayer = campaign.getCurrentPlayer();
        PropertyTile currPropertyTile = (PropertyTile) campaign.getTileUnderPlayer(currPlayer);
        Property currProperty = currPropertyTile.getProperty();
        initiateBuyLand();
        InitiateBuyPropertyOutputData initiateOutputDataQuestion;

        // The player lands on a Property Tile; whether the player wants to purchase the
        // landed on property is asked to the player.

        if (question == 1){
            // The player decides to attempt purchasing the landed on property, when the question is introduced.
            initiateOutputDataQuestion = new InitiateBuyPropertyOutputData("Would you like to " +
                    " purchase " + currProperty.getName() + " for " +
                    currProperty.getPrice() + "?", true);
        }

        // The player does not land on a Property Tile;  whether the player wants to purchase the
        // landed on property is not asked the player.

        else

        {
            initiateOutputDataQuestion = new InitiateBuyPropertyOutputData(null, false);
        }

        output.performAction(initiateOutputDataQuestion);


    }


}

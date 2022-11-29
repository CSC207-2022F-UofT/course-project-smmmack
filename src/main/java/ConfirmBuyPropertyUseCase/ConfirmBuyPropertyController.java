package ConfirmBuyPropertyUseCase;

import MainEntities.Campaign;
import MainEntities.Player;
import Properties.Property;
import MainEntities.CampaignAccess;
import Tiles.PropertyTile;

public class ConfirmBuyPropertyController {

    private ConfirmBuyPropertyInputBoundary inputBuyProperty;

    private CampaignAccess campaignAccess;
    private boolean decision;

    public ConfirmBuyPropertyController(ConfirmBuyPropertyInputBoundary inputBuyProperty, CampaignAccess campaignAccess) {
        this.inputBuyProperty = inputBuyProperty;
        this.campaignAccess = campaignAccess;
    }

    void performAction() throws Exception{
        Campaign campaign = campaignAccess.getCampaign();
        int currPlayerIndex;
        Player player;
        Property property;
        PropertyTile propertyTile;
        currPlayerIndex = campaign.getCurrPlayerIndex();
        player = campaign.getPlayerAt(currPlayerIndex);
        propertyTile = (PropertyTile) campaign.getTileUnderPlayer(player);
        property = propertyTile.getProperty();
        ConfirmBuyPropertyInputData inputData = new ConfirmBuyPropertyInputData(player, property, decision);
        inputBuyProperty.performAction(inputData);
    }

    // Getters:

    public ConfirmBuyPropertyInputBoundary getInputBuyProperty(){
        return inputBuyProperty;
    }

    public boolean getDecision(){
        return decision;
    }

    // Setter:

    public void setInputBuyProperty(ConfirmBuyPropertyInputBoundary inputBuyProperty){
        this.inputBuyProperty = inputBuyProperty;
    }

    public void setDecision(boolean decision){
        this.decision = decision;
    }
}

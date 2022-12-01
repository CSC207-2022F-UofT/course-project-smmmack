package ConfirmBuyPropertyUseCase;

import MainEntities.CampaignAccess;
import MainEntities.Player;
import Properties.Property;
import Tiles.PropertyTile;

public class ConfirmBuyPropertyInteractor implements ConfirmBuyPropertyInputBoundary {

    private final ConfirmBuyPropertyOutputBoundary result;
    private final Property property;
    private final Player player;
    private CampaignAccess campaignAccess;


    public ConfirmBuyPropertyInteractor(ConfirmBuyPropertyOutputBoundary buyPropertyOutputBoundary,
                                        CampaignAccess campaignAccess, Player player, Property property) {
        PropertyTile propertyTile;
        propertyTile = (PropertyTile) campaignAccess.getCampaign().getTileUnderPlayer(player);
        this.result = buyPropertyOutputBoundary;
        this.player = campaignAccess.getCampaign().getCurrentPlayer();
        this.property = propertyTile.getProperty();

    }

    public CampaignAccess getCampaignAccess() {
        return campaignAccess;
    }

    public void setCampaignAccess(CampaignAccess campaignAccess) {
        this.campaignAccess = campaignAccess;
    }

    /**
     *
     * @param decision The decision of the player rather to purchase or not purchase
     *                 the landed on property. If decision is true, then the player attempts
     *                 to purchase the property with buyProperty().
     */

    public void decisionBuyProperty(boolean decision){
        if (decision){
            buyProperty(campaignAccess);
        }
    }

    /**
     *
     * @param  campaignAccess Accesses the Campaign class.
     * @return An integer message informing the player about purchasing the property. There are 3
     *         types of messages indicated as 0, 1, and 2. If message is equals to 0, the property
     *         is already purchased and has an owner; if the message is equals to 2, the player does
     *         not have enough funds to purchase this property; if the message is equals to 1, the
     *         player has enough funds and thus can purchase this property, when player attempts to
     *         buy the property, player successfully purchases the property.
     */

    public int buyProperty(CampaignAccess campaignAccess){
        int message;
        int currPlayerIndex = campaignAccess.getCampaign().getCurrPlayerIndex();
        PropertyTile currPropertyTile = (PropertyTile) campaignAccess.getCampaign().getTileAt(currPlayerIndex);
        if (!(currPropertyTile.getProperty().getOwner() == null)){
            message = 0;
        } else {
            if (campaignAccess.getCampaign().getCurrentPlayer().getCash() >= currPropertyTile.getProperty().getPrice()){
                currPropertyTile.getProperty().setOwner(campaignAccess.getCampaign().getCurrentPlayer());
                campaignAccess.getCampaign().getCurrentPlayer().loseCash(currPropertyTile.getProperty().getPrice());
                campaignAccess.getCampaign().getCurrentPlayer().addProperty(currPropertyTile.getProperty());
                message = 1;
            } else {
                message = 2;
            }
        } return message;
    }

    @Override
    public void performAction(ConfirmBuyPropertyInputData buyPropertyInputData) throws Exception{
        int message = buyProperty(campaignAccess);
        ConfirmBuyPropertyOutputData outputDataMessage;
        try {
            if (message == 1) {
                outputDataMessage = new ConfirmBuyPropertyOutputData("You have purchased this property.",
                        true);
            } else if (message == 2) {
                outputDataMessage = new ConfirmBuyPropertyOutputData("This property is already purchased by "
                        + property.getOwner(), false);
            } else {
                outputDataMessage = new ConfirmBuyPropertyOutputData("Not have enough funds.",
                        false);
            }
        } catch (Exception buyProperty) {
            outputDataMessage = new ConfirmBuyPropertyOutputData("Error: Purchase cannot proceed.",
                    false);
        } result.performAction(outputDataMessage);
    }

}

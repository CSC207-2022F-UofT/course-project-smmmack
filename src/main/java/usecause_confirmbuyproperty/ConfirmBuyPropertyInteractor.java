package usecause_confirmbuyproperty;


import entities_main.Campaign;
import entities_main.CampaignAccess;
import entities_main.Player;
import entities_properties.Property;
import entities_tiles.PropertyTile;

public class ConfirmBuyPropertyInteractor implements ConfirmBuyPropertyInputBoundary {

    private ConfirmBuyPropertyOutputBoundary result;
    private CampaignAccess campaignAccess;


    public ConfirmBuyPropertyInteractor(ConfirmBuyPropertyOutputBoundary buyPropertyOutputBoundary,
                                        CampaignAccess campaignAccess) {
        this.result = buyPropertyOutputBoundary;
        this.campaignAccess = campaignAccess;
    }

    public ConfirmBuyPropertyInteractor(){

    }

    // CampaignAccess Getter & Setter:

    public CampaignAccess getCampaignAccess() {
        return campaignAccess;
    }

    public void setCampaignAccess(CampaignAccess campaignAccess) {
        this.campaignAccess = campaignAccess;
    }

    // ConfirmBuyPropertyOutputBoundary Getter & Setter:


    public ConfirmBuyPropertyOutputBoundary getResult() {
        return result;
    }

    public void setResult(ConfirmBuyPropertyOutputBoundary result) {
        this.result = result;
    }

    /**
     *
     * @param decision The decision of the player rather to purchase or not purchase
     *                 the landed on property. If decision is true corresponding to 'yes',
     *                 then the player attempts to purchase the property with buyProperty().
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
        Campaign campaign = campaignAccess.getCampaign();
        int message;
        int currPlayerIndex = campaign.getCurrPlayerIndex();
        Player currPlayer = campaign.getCurrentPlayer();
        PropertyTile currPropertyTile = (PropertyTile) campaign.getTileAt(currPlayerIndex);
        Property currProperty = currPropertyTile.getProperty();

        if (!(currProperty.getOwner() == null)){
            message = 0;
        } else {
            if (currPlayer.getCash() >= currProperty.getPrice()){
                currPlayer.loseCash(currProperty.getPrice());
                currPlayer.assignOwnership(currProperty);
                message = 1;
            } else {
                message = 2;
            }
        } return message;
    }

    @Override
    public void performAction(ConfirmBuyPropertyInputData buyPropertyInputData) throws Exception{
        int message = buyProperty(campaignAccess);
        Campaign campaign = campaignAccess.getCampaign();
        ConfirmBuyPropertyOutputData outputDataMessage;
        Player currPlayer = campaign.getCurrentPlayer();
        PropertyTile currPropertyTile = (PropertyTile) campaign.getTileUnderPlayer(currPlayer);
        Property currProperty = currPropertyTile.getProperty();
        int playerCashAfterPurchase = currPlayer.getCash() - currProperty.getPrice();

        try {
            // Case 1: The player successfully purchases the landed on property.
            if (message == 1) {
                outputDataMessage = new ConfirmBuyPropertyOutputData("You have purchased "
                        + currProperty.getName() + " for " + currProperty.getPrice() + ".","output",
                        campaign.getCurrPlayerIndex(), playerCashAfterPurchase, currProperty.getAbbreviation());
            }
            // Case 2: The player cannot purchase the landed on property, the property is already owned.

            else if (message == 2) {
                outputDataMessage = new ConfirmBuyPropertyOutputData(currProperty.getName() +
                        " is already purchased by "  + currProperty.getOwner(), "warning",
                        campaign.getCurrPlayerIndex(), playerCashAfterPurchase, currProperty.getAbbreviation());
            }
            // Case 3: The player cannot purchase the landed on property, the player does not have enough funds.

            else {
                outputDataMessage = new ConfirmBuyPropertyOutputData("Not have enough funds.",
                        "warning", campaign.getCurrPlayerIndex(), playerCashAfterPurchase,
                        currProperty.getAbbreviation());
            }
        } // Otherwise, throws error that the purchase cannot proceed.

        catch (Exception buyProperty) {
            outputDataMessage = new ConfirmBuyPropertyOutputData("Error: Purchase cannot proceed.",
                    "error", campaign.getCurrPlayerIndex(), playerCashAfterPurchase,
                    currProperty.getAbbreviation());
            result.performAction(outputDataMessage);
        } result.performAction(outputDataMessage);
    }

}

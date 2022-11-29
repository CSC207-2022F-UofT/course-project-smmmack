package ConfirmBuyPropertyUseCase;


import MainEntities.Player;
import Properties.Property;

public class ConfirmBuyPropertyInteractor implements ConfirmBuyPropertyInputBoundary {

    private ConfirmBuyPropertyOutputBoundary result;
    private Property property;
    private Player player;


    public ConfirmBuyPropertyInteractor(ConfirmBuyPropertyOutputBoundary buyPropertyOutputBoundary,
                                        Player player, Property property) {
        this.result = buyPropertyOutputBoundary;
        this.player = player;
        this.property = property;
    }

    /**
     *
     * @param decision The decision of the player rather to purchase or not purchase
     *                 the landed on property. If decision is true, then the player attempts
     *                 to purchase the property with buyProperty().
     */

    public void decisionBuyProperty(boolean decision){
        if (decision){
            buyProperty(player, property);
        }
    }

    /**
     *
     * @param player The player attempting to purchase the property.
     * @param property The property that the player landed on.
     * @return An integer message informing the player about purchasing the property. There are 3
     *         types of messages indicated as 0, 1, and 2. If message is equals to 0, the property
     *         is already purchased and has an owner; if the message is equals to 2, the player does
     *         not have enough funds to purchase this property; if the message is equals to 1, the
     *         player has enough funds and thus can purchase this property, when player attempts to
     *         buy the property, player successfully purchases the property.
     */

    public int buyProperty(Player player, Property property){
        int message;
        if (!(property.getOwner() == null)){
            message = 0;
        } else {
            if (player.getCash() >= property.getPrice()){
                property.setOwner(player);
                player.loseCash(property.getPrice());
                player.addProperty(property);
                message = 1;
            } else {
                message = 2;
            }
        } return message;
    }

    @Override
    public void performAction(ConfirmBuyPropertyInputData buyPropertyInputData) throws Exception{
        int message = buyProperty(player, property);
        ConfirmBuyPropertyOutputData outputDataMessage;
        if (message == 1){
            outputDataMessage = new ConfirmBuyPropertyOutputData("You have purchased this property.", true);
        } else if (message == 2) {
            outputDataMessage = new ConfirmBuyPropertyOutputData("This property is already purchased by "
                    + property.getOwner(), false);
        } else {
            outputDataMessage = new ConfirmBuyPropertyOutputData("Not have enough funds.", false);
        } result.performAction(outputDataMessage);
    }

    // 3 more variables: 1 boolean indicating of confirmPurchase at the BuyPropertyOutPutData.
    // playerIndex. Which player at which index bought the property.
    // propertyIndex. Which property at what index has been bought?

}

package BuyPropertyUseCase;


import MainEntities.Player;
import Properties.Property;

public class BuyPropertyInteractor implements BuyPropertyInputBoundary{

    private BuyPropertyOutputBoundary result;
    private Property property;
    private Player player;

    public BuyPropertyInteractor(BuyPropertyOutputBoundary buyPropertyOutputBoundary,
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
    public void create(BuyPropertyInputData buyPropertyInputData) throws Exception{
        int message = buyProperty(player, property);
        BuyPropertyOutputData outputDataMessage;
        if (message == 1){
            outputDataMessage = new BuyPropertyOutputData("You have purchased this property.");
        } else if (message == 2) {
            outputDataMessage = new BuyPropertyOutputData("This property is already purchased by "
                    + property.getOwner());
        } else {
            outputDataMessage = new BuyPropertyOutputData("Not have enough funds.");
        } result.create(outputDataMessage);
    }

}

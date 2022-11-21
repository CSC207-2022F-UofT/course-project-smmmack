package BuyProperty;


import MainEntities.Player;
import Properties.Property;

public class BuyPropertyInteractor implements BuyPropertyInputBoundary{

    final BuyPropertyOutputBoundary result;

    Property property;
    Player player;

    public BuyPropertyInteractor(BuyPropertyOutputBoundary buyPropertyOutputBoundary,
                                 Player player, Property property) {
        this.result = buyPropertyOutputBoundary;
        this.player = player;
        this.property = property;
    }

    /**
     *
     * @param player The player attempting to purchase the property.
     * @param property The property that the player landed on.
     * @return An integer message informing the player about purchasing the property if message is
     *         equals to 0, the property is already purchased and has an owner; if the message is
     *         equals to 2, the player does not have enough funds to purchase this property;
     *         if the message is equals to 1, the player has enough funds and thus can purchase
     *         this property, when player attempts to buy the property, player successfully
     *         purchases the property.
     */

    public int buyProperty(Player player, Property property){
        int message;

        if (!(property.getOwner() == null)) {
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
    public BuyPropertyOutputData create(BuyPropertyInputData inputBuyProperty) throws Exception {
            int message = buyProperty(player, property);
            if (message == 1) {
                return result.prepareSuccessView("You have purchased this property.");
            } else if (message == 0) {
                return result.prepareFailureView("This property is already purchased by " + property.getOwner());
            } else {
                return result.prepareFailureView("Not have enough funds.");
            }
    }







}

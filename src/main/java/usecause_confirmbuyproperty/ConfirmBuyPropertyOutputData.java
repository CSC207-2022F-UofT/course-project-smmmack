package usecause_confirmbuyproperty;

public class ConfirmBuyPropertyOutputData {

    String message;
    String confirmPurchase;
    int playerIndex;
    int playerCashAfterPurchase;
    String propertyAbbreviation;

    /**
     *
     * @param message The response message when the player is attempting to purchase the property that
     *                the player landed on; the attempt of purchasing can either be accepted or denied;
     *                further indicates the error message of an unsuccessful purchase to inform the player.
     *
     * @param confirmPurchase The boolean parameter indicating whether the purchase is verified; true for
     *                        successful purchase, false otherwise.
     *
     * @param playerIndex The integer parameter indicating the player's index who attempts to buy the
     *                    landed on property.
     *
     * @param propertyAbbreviation The String parameter indicating the landed on property's abbreviation.
     */

    public ConfirmBuyPropertyOutputData(String message, String confirmPurchase, int playerIndex,
                                        int playerCashAfterPurchase, String propertyAbbreviation){
        this.message = message;
        this.confirmPurchase = confirmPurchase;
        this.playerIndex = playerIndex;
        this.playerCashAfterPurchase = playerCashAfterPurchase;
        this.propertyAbbreviation = propertyAbbreviation;
    }

    // Getters:

    public String getMessage() {
        return message;
    }
    
    public String getConfirmPurchase(){
        return confirmPurchase;
    }

    public int getPlayerIndex(){
        return playerIndex;
    }

    public int getPlayerCashAfterPurchase() {
        return playerCashAfterPurchase;
    }

    public String getPropertyAbbreviation() {
        return propertyAbbreviation;
    }
    // Setters:

    public void setMessage(String message) {
        this.message = message;
    }
    public void setConfirmPurchase(String confirmPurchase){
        this.confirmPurchase = confirmPurchase;
    }

    public void setPlayerIndex(int playerIndex){
        this.playerIndex = playerIndex;
    }

    public void setPlayerCashAfterPurchase(int playerCashAfterPurchase) {
        this.playerCashAfterPurchase = playerCashAfterPurchase;
    }

    public void setPropertyAbbreviation(String propertyAbbreviation) {
        this.propertyAbbreviation = propertyAbbreviation;
    }
}

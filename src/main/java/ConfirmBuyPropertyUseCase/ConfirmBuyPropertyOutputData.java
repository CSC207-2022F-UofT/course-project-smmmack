package ConfirmBuyPropertyUseCase;

public class ConfirmBuyPropertyOutputData {

    String message;
    String confirmPurchase;
    int playerIndex;

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
     */

    public ConfirmBuyPropertyOutputData(String message, String confirmPurchase, int playerIndex){
        this.message = message;
        this.confirmPurchase = confirmPurchase;
        this.playerIndex = playerIndex;
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

}

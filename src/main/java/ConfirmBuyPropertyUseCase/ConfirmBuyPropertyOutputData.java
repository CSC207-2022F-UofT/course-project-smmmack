package ConfirmBuyPropertyUseCase;

public class ConfirmBuyPropertyOutputData {

    String message;
    boolean confirmPurchase;

    /**
     *
     * @param message The response message when the player is attempting to purchase the property that
     *                the player landed on; the attempt of purchasing can either be accepted or denied;
     *                further indicates the error message of an unsuccessful purchase to inform the player.
     *
     * @param confirmPurchase The boolean parameter indicating whether the purchase is verified; true for
     *                        successful purchase, false otherwise.
     */

    public ConfirmBuyPropertyOutputData(String message, boolean confirmPurchase){
        this.message = message;
        this.confirmPurchase = confirmPurchase;
    }

    // Getters:

    public String getMessage() {
        return message;
    }

    public boolean getConfirmPurchase(){
        return confirmPurchase;
    }

    // Setters:

    public void setMessage(String message) {
        this.message = message;
    }

    public void setConfirmPurchase(boolean confirmPurchase){
        this.confirmPurchase = confirmPurchase;
    }

}

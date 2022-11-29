package ConfirmBuyPropertyUseCase;

public class ConfirmBuyPropertyOutputData {

    String message;
    boolean confirmPurchase;

    /**
     *
     * @param message The response message when the player is attempting to purchase the property that
     *                the player landed on; the attempt of purchasing can either be accepted or denied.
     */

    public ConfirmBuyPropertyOutputData(String message, boolean confirmPurchase){
        this.message = message;
        this.confirmPurchase = confirmPurchase;
    }

    public String getMessage() {
        return message;
    }

    public boolean getConfirmPurchase(){
        return confirmPurchase;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setConfirmPurchase(boolean confirmPurchase){
        this.confirmPurchase = confirmPurchase;
    }

    // 3 more variables: 1 boolean indicating of confirmPurchase at the BuyPropertyOutPutData.
    // playerIndex. Which player at which index bought the property.
    // propertyIndex. Which property at what index has been bought?

}

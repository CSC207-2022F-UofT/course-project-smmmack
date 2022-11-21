package BuyProperty;

public class BuyPropertyOutputData {

    String message;

    /**
     *
     * @param message The response message when the player is attempting to purchase the property that
     *                the player landed on; the attempt of purchasing can either be accepted or denied.
     */

    public BuyPropertyOutputData(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

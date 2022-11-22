package BuyProperty;

public class BuyPropertyInputData {

    boolean decision;

    /**
     *
     * @param decision The decision of the player when given the option to either buy the property
     *                 that the player landed on or not.
     */


    public BuyPropertyInputData(boolean decision) {
        this.decision = decision;
    }

    public boolean getDecision() {
        return decision;
    }

    public void setDecision(boolean decision) {
        this.decision = decision;
    }

}

package ConfirmBuyPropertyUseCase;

public class ConfirmBuyPropertyInputData {
    boolean decision;

    /**
     *
     * @param decision The decision of attempting to purchase the landed on
     *                 property; true if the player attempts to purchase the
     *                 landed on property; false otherwise.
     */

    public ConfirmBuyPropertyInputData(boolean decision) {
        this.decision = decision;
    }

    // Getter:

    public boolean getDecision() {
        return decision;
    }

    // Setter:

    public void setDecision(boolean decision){
        this.decision = decision;
    }

}

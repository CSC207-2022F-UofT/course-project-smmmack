package ConfirmBuyPropertyUseCase;

public class ConfirmBuyPropertyInputData {
    boolean decision;

    /**
     *
     * @param decision The boolean, decision indicating the attempt to purchase
     *                 the landed on property; yes corresponds to true if the
     *                 player attempts to purchase the landed on property; no
     *                 corresponds to false otherwise.

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

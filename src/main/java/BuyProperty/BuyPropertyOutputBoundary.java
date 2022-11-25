package BuyProperty;

public interface BuyPropertyOutputBoundary {

    /**
     *
     * @param message Message to be displayed for the user.
     * @return The resulting message informing the player about
     * the successful purchase.
     */

    BuyPropertyOutputData prepareSuccessView(String message);

    /**
     *
     * @param message Message to be displayed for the user.
     * @return The resulting message informing the player about the
     * reason of the unsuccessful purchase, either the property is already
     * owned or the player does not have enough funds to purchase the landed
     * property.
     */
    BuyPropertyOutputData prepareFailureView(String message);

}

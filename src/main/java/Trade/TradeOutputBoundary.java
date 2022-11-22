package Trade;
import java.io.IOException;

public interface TradeOutputBoundary {
    //change to private`

    /**
     * Prints the results of the Trade to user.
     * @param results Message to be displayed to user.
     * @return The result of the trade if successful
     */
    TradeOutputData prepareSuccessView(String results);

    /**
     * Prompt the user to enter a valid input.
     * @param inputAgain Message to be displayed to user.
     * @return a message asking users to input a valid String.
     */
    TradeOutputData prepareFailureView(String inputAgain);

}
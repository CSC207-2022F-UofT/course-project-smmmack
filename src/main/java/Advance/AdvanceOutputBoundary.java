package Advance;
import java.io.IOException;

public interface AdvanceOutputBoundary {

    /**
     * Prints the results of the dice roll to user.
     * @param results Message to be displayed to user.
     * @return The result of the dice roll if successful
     */
    AdvanceOutputData prepareSuccessView(String results);

    /**
     * Prompt the user to enter a valid input.
     * @param inputAgain Message to be displayed to user.
     * @return a message asking users to input a valid String.
     */
    AdvanceOutputData prepareFailureView(String inputAgain);

}

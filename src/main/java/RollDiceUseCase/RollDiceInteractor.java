package RollDiceUseCase;

import MainEntities.GameBoard;
import MainEntities.Player;
import MainEntities.CampaignAccess;
import AdvanceUseCase.*;

public class RollDiceInteractor implements RollDiceInputBoundary{

    final RollDiceOutputBoundary output;

    final CampaignAccess campaignAccess;

    final GameBoard board;

    Player player;

    AdvanceInputBoundary advanceInputBoundary;

    public RollDiceInteractor(RollDiceOutputBoundary output, CampaignAccess campaignAccess, AdvanceInputBoundary
                              advanceInputBoundary) {
        this.output = output;
        this.campaignAccess = campaignAccess;
        board = campaignAccess.getCampaign().getBoard();
        player = campaignAccess.getCampaign().getCurrentPlayer();
        this.advanceInputBoundary = advanceInputBoundary;
    }

    /**
     * @return the result of two random 6-sided dice rolls, stored in an integer array.
     */
    private int[] generateDiceRoll(){
        int dice1 = (int) Math.floor(Math.random() * 7 + 1);
        int dice2 = (int) Math.floor(Math.random() * 7 + 1);
        return new int[]{dice1, dice2};
    }

    /**
     * rollDice() generates dice rolls and calls the Advance use case accordingly. If a double is rolled, the player
     * will be asked to roll again. If three doubles are rolled in a row, the player will be sent to jail.
     * @param numDoubles the number of doubles rolled so far
     */
    public void rollDice(int numDoubles) throws Exception {

        int[] diceRolls = generateDiceRoll();

        // Set up new input data for advance use case.
        AdvanceInputData advanceInput = new AdvanceInputData(diceRolls[0] + diceRolls[1]);


        //If a double is rolled:
        if (diceRolls[0] == diceRolls[1]) {
            if (numDoubles == 2) {
                // Sends player to jail if three doubles are rolled
            } else {
                // Otherwise call advance use case, then let user roll dice again using recursive call.
                advanceInputBoundary.performAction(advanceInput);
                rollDice(numDoubles + 1);
            }
        }
        else { // If a double is not rolled.
            advanceInputBoundary.performAction(advanceInput);
        }
    }

    /**
     * Performs the dice rolls and updates the presenter.
     * @param input RollDiceInputData used to check if the
     * @throws Exception if the tile that the user lands on is not valid
     */
    @Override
    public void performAction(RollDiceInputData input) throws Exception {
        // If the user successfully confirmed the roll.
        if (input.isConfirmRoll()) {
            // Roll dice and move player to correct tile as needed.
            rollDice(0);
            RollDiceOutputData outputMessage =
                    new RollDiceOutputData("Your dice roll was successful.", true);
            output.performAction(outputMessage);
        }
        // If the user did not confirm the roll
        else {
            RollDiceOutputData outputMessage =
                    new RollDiceOutputData("Please press any key to roll dice.", false);
            output.performAction(outputMessage);
        }
    }
}

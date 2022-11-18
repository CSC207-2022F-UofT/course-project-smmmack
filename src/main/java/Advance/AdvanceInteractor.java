package Advance;
import MainEntities.Player;
import MainEntities.GameBoard;
import Tiles.Tile;

public class AdvanceInteractor implements AdvanceInputBoundary{

    final AdvancePresenter advancePresenter;
    final AdvanceOutputBoundary output;

    final GameBoard board;

    Player player;

    public AdvanceInteractor(AdvancePresenter advancePresenter, AdvanceOutputBoundary output, GameBoard board,
                             Player player) {
        this.advancePresenter = advancePresenter;
        this.output = output;
        this.board = board;
        this.player = player;
    }

    /**
     * @return an int array of size 2, where each element is one random dice roll.
     */
    public int[] GenerateDiceRoll() {
        int dice1 = (int) Math.floor(Math.random() * 7 + 1);
        int dice2 = (int) Math.floor(Math.random() * 7 + 1);
        int[] rolls = {dice1, dice2};
        return rolls;
    }

    /**
     * Advances the player depending on two dice rolls.
     * @param rolls An array containing two dice rolls.
     * @param numDoubles The number of doubles that the player has rolls thus dar.
     * @return a String indicating the result of the dice roll.
     */
    public String advancePlayer(int[] rolls, int numDoubles) {

        if (rolls[0] == rolls[1]) {
            if (numDoubles == 2) {
                // Sends player to jail if three doubles are rolled
                player.setJailTurn(3);
                return "Jail.";
            } else {
                // Otherwise, allows user to roll dice again.
                player.setLocation(rolls[0] + rolls[1] + player.getLocation());
                return advancePlayer(GenerateDiceRoll(), numDoubles + 1);
            }
        }
        // If the roll isn't a double:
        player.setLocation(rolls[0] + rolls[1] + player.getLocation());
        return player.getName() + " moved to tile " + player.getLocation()
                + ", which is a " + player.getLocation();
    }

    /**
     * Allows the player to make an action based off the tile they are on.
     * @param tileIndex the index of the tile that the player is on.
     */
    public void performTileAction(int tileIndex) {
        Tile tile = this.board.getTileAt(tileIndex);

        // Need to add code to perform tile actions after other use cases are finished.
        // Maybe this should be a separate use case.

    }

    @Override
    public AdvanceOutputData create(AdvanceInputData input){
        if (input.getConfirm() != null) {
            String result = advancePlayer(GenerateDiceRoll(), 0);
            return output.prepareSuccessView("You have landed on this location: " + result);
        }
        else {
            return output.prepareFailureView("Please press any key to roll dice.");
        }

    }
}

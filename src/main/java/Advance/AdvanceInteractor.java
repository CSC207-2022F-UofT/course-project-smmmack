package Advance;
import MainEntities.Player;
import MainEntities.GameBoard;
import Tiles.DrawCardTile;
import Tiles.GoToJailTile;
import Tiles.Tile;

public class AdvanceInteractor implements AdvanceInputBoundary{
    /*
    The Advance use case advances the player to a specific location on the board depending on the dice roll passed by
    AdvanceController.
     */

    final AdvanceOutputBoundary output;

    final GameBoard board;

    Player player;

    public AdvanceInteractor(AdvanceOutputBoundary output, GameBoard board, AdvanceController controller,
                             Player player) {
        this.output = output;
        this.board = board;
        this.player = player;
    }

    /**
     * Advances the player to a new tile based off of diceSum. Calls on performTileAction to allow the user to
     * perform the tile's corresponding action.
     * @param diceSum the result of two dice rolls
     */
    public void advancePlayer(int diceSum) throws Exception {
        player.setLocation(diceSum + player.getLocation());
        performTileAction(player.getLocation());
    }

    /**
     * Allows the player to make an action based off the tile they are on.
     * @param tileIndex the index of the tile that the player is on.
     */
    public void performTileAction(int tileIndex) throws Exception {
        Tile tile = this.board.getTileAt(tileIndex);

        if (tile.getClass().getName().equals("DrawCardTile")){
            // Calls on DrawCard use case after it is finished.
        } else if (tile.getClass().getName().equals("GoToJailTile")) {
            // Calls on GoToJail use case after it is finished.
        } else if (tile.getClass().getName().equals("JailTile")) {
            // Do nothing as the tile has no user actions.
            return;
        } else if (tile.getClass().getName().equals("ParkingTile")) {
            // Do nothing as the tile has no user actions.
            return;
        } else if (tile.getClass().getName().equals("PropertyTile")) {
            // Calls on BuyProperty and PayRent use case after it is finished.
            // What happens if the property is owned? If it isn't?
        } else if (tile.getClass().getName().equals("StartTile")) {
            // Calls on Start Tile use case? Will need to be discussed.
        }
        else{
            throw new Exception("Tile not found.");
        }
    }

    @Override
    public AdvanceOutputData create(AdvanceInputData input) throws Exception {
        if (input.isConfirmRoll()) {
            advancePlayer(input.diceSum);
            return output.prepareSuccessView("You have landed on this tile: " + player.getLocation());
        }
        else {
            return output.prepareFailureView("Please press any key to roll dice.");
        }
    }
}

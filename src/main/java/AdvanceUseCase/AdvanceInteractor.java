package AdvanceUseCase;
import MainEntities.Player;
import MainEntities.GameBoard;
import Tiles.*;

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
        int tilesMoved = diceSum + player.getLocation();
        // If the player will move past start, add $200 to the player's cash
        if (tilesMoved > board.getSize()){
            player.setLocation(board.getSize() - tilesMoved);
            player.gainCash(200);
            performTileAction(player.getLocation());
        }
        else {
            player.setLocation(diceSum + player.getLocation());
            performTileAction(player.getLocation());
        }
    }

    /**
     * Allows the player to make an action based off the tile they are on.
     * @param tileIndex the index of the tile that the player is on.
     */
    public void performTileAction(int tileIndex) throws Exception {
        Tile tile = this.board.getTileAt(tileIndex);

        if (tile instanceof DrawCardTile){
            // Calls on DrawCard use case after it is finished.
        } else if (tile instanceof GoToJailTile) {
            // Calls on GoToJail use case after it is finished.
        } else if (tile instanceof JailTile) {
            // Do nothing as the tile has no user actions.
            return;
        } else if (tile instanceof ParkingTile) {
            // Do nothing as the tile has no user actions.
            return;
        } else if (tile instanceof PropertyTile) {
            // Calls on BuyProperty and PayRent use case after it is finished.
            // What happens if the property is owned? If it isn't?
        } else if (tile instanceof StartTile) {
            // Calls on Start Tile use case? Will need to be discussed.
        }
        else{
            throw new Exception("Tile not found.");
        }
    }

    // Todo: may need to changeoutput message depending on tile type.
    @Override
    public void create(AdvanceInputData input) throws Exception {
        if (input.isConfirmRoll()) {
            advancePlayer(input.diceSum);
            AdvanceOutputData outputMessage =
                    new AdvanceOutputData("You have landed on this tile: " + player.getLocation());
            output.create(outputMessage);
        }
        else {
            AdvanceOutputData outputMessage =
                    new AdvanceOutputData("Please press any key to roll dice.");
            output.create(outputMessage);
        }
    }
}

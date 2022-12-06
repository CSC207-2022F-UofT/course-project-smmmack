package GoToJailUserCase;

import MainEntities.GameBoard;
import MainEntities.Player;
import Tiles.GoToJailTile;

public class GoToJailInteractor implements GoToJailInputBoundary{
    final GoToJailOutputBoundary output;
    final GameBoard board;
    Player player;
    GoToJailTile jailTile;


    public GoToJailInteractor(GameBoard board, GoToJailOutputBoundary output, GoToJailTile jailTile,
                                  Player player) {
        this.output = output;
        this.board = board;
        this.jailTile = jailTile;
        this.player = player;
    }

    /**
     * To find the index of the jail
     * @param board The board of the game.
     * @param jailTile The class that contains the information that where a player will go to jail
     */

    public int jailIndex(GoToJailTile jailTile, GameBoard board){
        int index=0;
        while (board.getTileAt(index) != jailTile.getJailTile()){
            index++;
        }
        return index;
    }

    /**
     * To check if the player is on the tile that will go the jail, if he is jail is true, if he
     * is not, jail is false
     * @param player The player of the game.
     * @param jailTile The class that contains the information that where a player will go to jail
     */

    public boolean isPlayerInJail(Player player, GoToJailTile jailTile){
        return player.getLocation()==(jailIndex(jailTile, board));
    }

    /**
     * If the player is in jail, sent him to the jail and shows "You are in jail".
     * @param inputData The input of the game.
     */

    @Override
    public void create (GoToJailInputData inputData) throws Exception {
        inputData.inJail = isPlayerInJail(player, jailTile);
        GoToJailOutputData outputData;
        player.setLocation(jailIndex(jailTile, board));
        new GoToJailOutputData("You are in jail ");
        outputData = new GoToJailOutputData("You are in jail");
        output.create(outputData);
    }

}

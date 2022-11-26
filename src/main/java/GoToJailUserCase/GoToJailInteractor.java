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

    public int jailIndex(GoToJailTile jailTile, GameBoard board){
        int index=0;
        while (board.getTileAt(index) != jailTile.getJailTile()){
            index++;
        }
        return index;
    }

    public boolean inJail(Player player, GoToJailTile jailTile){
        boolean jail;
        jail = player.getLocation()==(jailIndex(jailTile, board));
        return jail;
    }

    @Override
    public void create (GoToJailInputData inputData) throws Exception {
        inputData.jail = inJail(player, jailTile);
        GoToJailOutputData outputData;
        player.setLocation(jailIndex(jailTile, board));
        new GoToJailOutputData("You are in jail ");
        outputData = new GoToJailOutputData("You are in jail");
        output.create(outputData);
    }

}

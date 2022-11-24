package GoToJailUserCase;

import MainEntities.GameBoard;
import MainEntities.Player;
import Tiles.JailTile;
import Tiles.GoToJailTile;
import java.time.LocalDateTime;

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


    public GoToJailOutputData create(GoToJailInputData input) throws Exception {
        boolean jail = inJail(player, jailTile);
        if (jail) {
            player.setLocation(jailIndex(jailTile, board));
            return output.prepareSuccessView("You are in jail: " );
        }
        else{
            return output.prepareFailureView("Please press any key to roll dice.");
        }
    }
}

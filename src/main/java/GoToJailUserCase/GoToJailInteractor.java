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


    @Override


    public GoToJailOutputData create(GoToJailInputData input) throws Exception {
        if (input.jail) {
            player.setLocation(player.getJailTurn());
            return output.prepareSuccessView("You are in jail: " );
        }
        else{
            return output.prepareFailView("Please press any key to roll dice.");
        }
    }
}

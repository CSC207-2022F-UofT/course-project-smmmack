package tradeUseCase;
import MainEntities.Player;
import Properties.NormalProperty;
import java.util.ArrayList;


public class tradeController {
    //change to private`

    final tradeInputBoundary input;
    final Player player1;

    public tradeController(tradeInputBoundary input, Player player1, Player player2) {
        this.input = input;
        this.player1 = player1;
    }

    void preformAction() throws Exception {
        tradeInputData inputData = new tradeInputData(player1, new ArrayList<NormalProperty>(),
                new ArrayList<NormalProperty>(), 0, 0);
        input.preformAction(inputData);
    }



}
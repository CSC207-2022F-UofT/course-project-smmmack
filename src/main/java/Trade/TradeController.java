package Trade;
import MainEntities.Player;
import Properties.NormalProperty;
import java.util.ArrayList;


public class TradeController {

    final TradeInputBoundary input;
    final Player player1;

    public TradeController(TradeInputBoundary input, Player player1, Player player2) {
        this.input = input;
        this.player1 = player1;
    }

    TradeOutputData create() throws Exception {
        TradeInputData inputData = new TradeInputData(player1, new ArrayList<NormalProperty>(),
                new ArrayList<NormalProperty>(), 0, 0);
        return input.create(inputData);
    }



}
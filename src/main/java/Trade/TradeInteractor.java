package Trade;
import MainEntities.Campaign;
import MainEntities.Player;
import Properties.NormalProperty;
import Properties.Property;


import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
/**
 * TradeInteractor is a class that handles the trade between two players.
 */
public class TradeInteractor implements TradeInputBoundary {
    final TradeOutputBoundary output;
    final Campaign campaign;
    Player player1;
    Player player2;

    ArrayList<NormalProperty> player1Properties;
    ArrayList<NormalProperty> player2Properties;
    int player1Cash;
    int player2Cash;

    public TradeInteractor(TradeOutputBoundary output, Player player2, Campaign campaign, ArrayList<NormalProperty> player1Properties,
                           ArrayList<NormalProperty> player2Properties, int player1Cash, int player2Cash) {
        this.output = output;
        this.player2 = player2;
        this.campaign = campaign;
        this.player1Properties = player1Properties;
        this.player2Properties = player2Properties;
        this.player1Cash = player1Cash;
        this.player2Cash = player2Cash;
    }

    /**
     * Makes the trade, player1 gives player2 player1Properties and player1Cash, and player2 gives player1 player2Properties and player2Cash.
     *
     * @param player1Properties, player2Properties, player1Cash, player2Cash the properties and cash that the players are trading
     * @return void
     */
    public void trade(ArrayList<NormalProperty> player1Properties, ArrayList<NormalProperty> player2Properties, int player1Cash, int player2Cash) {
        player1.setCash(player1.getCash() - player1Cash + player2Cash);
        player2.setCash(player2.getCash() - player2Cash + player1Cash);
        for (NormalProperty property : player1Properties) {
            player1.removeProperty(property);
            player2.addProperty(property);
            player2.assignOwnership(property);
        }
        for (NormalProperty property : player2Properties) {
            player2.removeProperty(property);
            player1.addProperty(property);
            player1.assignOwnership(property);
        }
    }


    @Override
    public TradeOutputData create(TradeInputData input) throws Exception {
        Player player1 = campaign.getCurrentPlayer();
        if(input.isTradeValid() && input.isConfirmTrade()){
            trade(player1Properties, player2Properties, player1Cash, player2Cash);
            return output.prepareSuccessView(true);
        }
        else {
            return output.prepareFailureView("Trade Failed!");
        }
    }
}



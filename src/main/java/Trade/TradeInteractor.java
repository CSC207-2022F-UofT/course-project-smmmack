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
        if (player1Cash < 0 || player2Cash < 0) {
            throw new InvalidParameterException("Cash cannot be negative");
        }
        if (player1Cash > player1.getCash() || player2Cash > player2.getCash()) {
            throw new InvalidParameterException("Cash cannot be greater than the player's cash");
        }
        if (player1Properties.size() > player1.getProperties().size() || player2Properties.size() > player2.getProperties().size()) {
            throw new InvalidParameterException("Properties cannot be greater than the player's properties");
        }
        for (NormalProperty property : player1Properties) {
            if (!player1.getProperties().contains(property)) {
                throw new InvalidParameterException("Player 1 does not own this property");
            }
        }
        for (NormalProperty property : player2Properties) {
            if (!player2.getProperties().contains(property)) {
                throw new InvalidParameterException("Player 2 does not own this property");
            }
        }
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
        if (player1.getCash() > input.player1Cash) {
            throw new Exception("Player 1 does not have enough cash");
        }
        return null;
    }
}



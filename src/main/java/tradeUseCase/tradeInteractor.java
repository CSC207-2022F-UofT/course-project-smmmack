package tradeUseCase;
import MainEntities.CampaignAccess;
import MainEntities.Player;
import Properties.NormalProperty;
import Properties.Property;


import java.util.ArrayList;

/**
 * TradeInteractor is a class that handles the trade between two players.
 */
public class tradeInteractor implements tradeInputBoundary {
    final tradeOutputBoundary output;
    final CampaignAccess campaign;
    Player player1;
    Player player2;

    ArrayList<NormalProperty> player1Properties;
    ArrayList<NormalProperty> player2Properties;
    int player1Cash;
    int player2Cash;

    public tradeInteractor(tradeOutputBoundary output, Player player2, CampaignAccess campaign, ArrayList<NormalProperty> player1Properties,
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
     * @param player1Properties The properties that the player who is trading is offering.
     * @param player2Properties The properties that the player who is trading is asking for.
     * @param player1Cash The amount of cash that the player who is trading is offering.
     * @param player2Cash The amount of cash that the player who is trading is asking for.
     */
    public void trade(ArrayList<NormalProperty> player1Properties, ArrayList<NormalProperty> player2Properties,
                      int player1Cash, int player2Cash) {
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

    /**
     * Checks if the trade is valid.
     *
     * @return boolean
     */
    public boolean isTradeValid() {
        if (player1Cash < campaign.getCampaign().getCurrentPlayer().getCash() && player2Cash < player2.getCash()) {
            for (Property property : campaign.getCampaign().getCurrentPlayer().getProperties()) {
                if (player1Properties.contains(property) && property.getHouseLevel() == 0) {
                    for (Property property2 : player2.getProperties()) {
                        if (player2Properties.contains(property2) && property2.getHouseLevel() == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    @Override
    public void preformAction(tradeInputData input) throws Exception {
        Player player1 = campaign.getCampaign().getCurrentPlayer();
        if (isTradeValid() && input.isConfirmTrade()) {
            trade(player1Properties, player2Properties, player1Cash, player2Cash);
            tradeOutputData outputMessage =
                    new tradeOutputData(true, "You traded" + player1Properties + "and" + player1Cash + "for"
                            + player2Properties + "and" + player2Cash);
            output.create(outputMessage);
        } else {
            tradeOutputData outputMessage =
                    new tradeOutputData(false, "Trade failed" + player2.getName()
                            + "Declined your trade");
            output.create(outputMessage);
        }
    }
}



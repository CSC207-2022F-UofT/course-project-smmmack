package tradeUseCase;
import MainEntities.CampaignAccess;
import MainEntities.Player;
import Properties.NormalProperty;
import Properties.Property;


import java.util.ArrayList;
import java.util.List;

/**
 * TradeInteractor is a class that handles the trade between two players.
 */
public class tradeInteractor implements tradeInputBoundary {
    private tradeOutputBoundary output;
    private CampaignAccess campaign;
    private tradeInputData inputData;

    public tradeInteractor(tradeOutputBoundary output, CampaignAccess campaign) {
        this.output = output;
        this.campaign = campaign;
    }

    /**
     * @param player1Properties The properties that the player who is trading is offering.
     * @param player2Properties The properties that the player who is trading is asking for.
     * @param player1Cash The amount of cash that the player who is trading is offering.
     * @param player2Cash The amount of cash that the player who is trading is asking for.
     */
    public void trade(Player player1, Player player2, ArrayList<NormalProperty> player1Properties,
                      ArrayList<NormalProperty> player2Properties, int player1Cash, int player2Cash) {
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
    public boolean isTradeValid(Player player1, Player player2, ArrayList<NormalProperty> player1Properties,
                                ArrayList<NormalProperty> player2Properties, int player1Cash, int player2Cash) {
        if (player1Cash < player1.getCash() && player2Cash < player2.getCash()) {
            for (Property property : player1.getProperties()) {
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
    public void performAction(tradeInputData inputData){
        this.inputData = inputData;
        Player player1 = campaign.getCampaign().getCurrentPlayer();
        Player player2 = campaign.getCampaign().getPlayerCalled(inputData.getPlayer2());
        int player1Cash = inputData.getPlayer1Cash();
        int player2Cash = inputData.getPlayer2Cash();
        ArrayList<NormalProperty> player1Properties = new ArrayList<>();
        ArrayList<NormalProperty> player2Properties = new ArrayList<>();
        List<Integer> player1PropertyIndexes = null;
        List<Integer> player2PropertyIndexes = null;
        for (String property : inputData.getPlayer1Properties()) {
            player1Properties.add((NormalProperty) campaign.getCampaign().getPropertyByAbbr(property));
            player1PropertyIndexes.add(campaign.getCampaign().getTileIndexByAbbr(property));
        }
        for (String property : inputData.getPlayer2Properties()) {
            player2Properties.add((NormalProperty) campaign.getCampaign().getPropertyByAbbr(property));
            player2PropertyIndexes.add(campaign.getCampaign().getTileIndexByAbbr(property));
        }


        if (isTradeValid(player1, player2, player1Properties, player2Properties, player1Cash, player2Cash)
                && inputData.isConfirmTrade()) {
            trade(player1, player2, player1Properties, player2Properties, player1Cash, player2Cash);
            tradeOutputData outputMessage =
                    new tradeOutputData(true, "You traded" + inputData.getPlayer1Properties() + "and" + player1Cash + "for"
                            + inputData.getPlayer2Properties() + "and" + player2Cash, campaign.getCampaign().getCurrPlayerIndex(),
                            campaign.getCampaign().getPlayerIndex(player2), player1.getCash(), player2.getCash(),
                            inputData.getPlayer2Properties(), inputData.getPlayer1Properties(), player2PropertyIndexes, player1PropertyIndexes); ;
            output.performAction(outputMessage);
        } else {
            tradeOutputData outputMessage =
                    new tradeOutputData(false, "Trade failed" + player2.getName()
                            + "Declined your trade",campaign.getCampaign().getCurrPlayerIndex(),
                            campaign.getCampaign().getPlayerIndex(player2), player1.getCash(), player2.getCash(),
                            inputData.getPlayer2Properties(), inputData.getPlayer1Properties(),player2PropertyIndexes, player1PropertyIndexes);
            output.performAction(outputMessage);
        }
    }
    //Getters and Setters
    public tradeOutputBoundary getOutput() {
        return output;
    }


}



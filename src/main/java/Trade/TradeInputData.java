package Trade;
import MainEntities.Player;
import Properties.NormalProperty;
import MainEntities.Campaign;
import Properties.Property;

import java.util.ArrayList;

public class TradeInputData {
    //change to private`
    boolean confirmTrade;
    Player player2;
    Campaign campaign;

    ArrayList<NormalProperty> player1Properties;

    ArrayList<NormalProperty> player2Properties;

    int player1Cash;

    int player2Cash;


    public TradeInputData(Player player2, ArrayList<NormalProperty> player1Properties,
                          ArrayList<NormalProperty> player2Properties,
                          int player1Cash, int player2Cash) {
        this.confirmTrade = true;
        this.player2 = player2;
        this.player1Properties = player1Properties;
        this.player2Properties = player2Properties;
        this.player1Cash = player1Cash;
        this.player2Cash = player2Cash;
    }

    public boolean isTradeValid() {
        if (player1Cash < campaign.getCurrentPlayer().getCash() && player2Cash < player2.getCash()) {
            for (Property property : campaign.getCurrentPlayer().getProperties()) {
                if (player1Properties.contains(property)) {
                    for (Property property2 : player2.getProperties()) {
                        if (player2Properties.contains(property2)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isConfirmTrade() {
        return confirmTrade;
    }
}
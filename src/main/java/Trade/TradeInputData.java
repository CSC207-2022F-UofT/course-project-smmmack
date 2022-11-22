package Trade;
import MainEntities.Player;
import Properties.NormalProperty;

import java.util.ArrayList;

public class TradeInputData {
    boolean confirmTrade;
    Player player1;

    ArrayList<NormalProperty> player1Properties;

    ArrayList<NormalProperty> player2Properties;

    int player1Cash;

    int player2Cash;


    public TradeInputData(Player player1, ArrayList<NormalProperty> player1Properties,
                          ArrayList<NormalProperty> player2Properties,
                          int player1Cash, int player2Cash) {
        this.confirmTrade = true;
        this.player1 = player1;
        this.player1Properties = player1Properties;
        this.player2Properties = player2Properties;
        this.player1Cash = player1Cash;
        this.player2Cash = player2Cash;
    }

    public boolean isConfirmTrade() {
        return confirmTrade;
    }
}
package tradeUseCase;
import MainEntities.Player;
import Properties.NormalProperty;

import java.util.ArrayList;

public class tradeInputData {
    //change to private`
    boolean confirmTrade;
    Player player2;

    ArrayList<NormalProperty> player1Properties;

    ArrayList<NormalProperty> player2Properties;

    int player1Cash;

    int player2Cash;

    /**
     *
     * @param player2 The player who is being traded with.
     * @param player1Properties The properties that the player who is trading is offering.
     * @param player2Properties The properties that the player who is trading is asking for.
     * @param player1Cash The amount of cash that the player who is trading is offering.
     * @param player2Cash The amount of cash that the player who is trading is asking for.
     */


    public tradeInputData(Player player2, ArrayList<NormalProperty> player1Properties,
                          ArrayList<NormalProperty> player2Properties,
                          int player1Cash, int player2Cash) {
        this.confirmTrade = true;
        this.player2 = player2;
        this.player1Properties = player1Properties;
        this.player2Properties = player2Properties;
        this.player1Cash = player1Cash;
        this.player2Cash = player2Cash;
    }

    public boolean isConfirmTrade() {
        return confirmTrade;
    }
}
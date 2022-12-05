package tradeUseCase;
import MainEntities.Player;
import Properties.NormalProperty;

import java.util.ArrayList;
/**
 * TradeInteractor is a class that handles the trade between two players.
 */

public class tradeInputData {
    //change to private`
    boolean confirmTrade;
    String player2;

    String[] player1Properties;

    String[] player2Properties;

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


    public tradeInputData(String player2, String[] player1Properties,
                          String[] player2Properties, int player1Cash, int player2Cash) {
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

    //getters
    public String getPlayer2() {
        return player2;
    }

    public String[] getPlayer1Properties() {
        return player1Properties;
    }

    public String[] getPlayer2Properties() {
        return player2Properties;
    }

    public int getPlayer1Cash() {
        return player1Cash;
    }

    public int getPlayer2Cash() {
        return player2Cash;
    }

}


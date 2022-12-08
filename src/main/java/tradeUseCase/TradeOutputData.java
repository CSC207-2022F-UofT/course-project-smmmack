package tradeUseCase;
//

import java.util.List;

public class TradeOutputData {
    private Boolean tradeSuccess;
    private String tradeMessage;
    private int player1Index;
    private int player2Index;
    private int player1NewMoney;
    private int player2NewMoney;
    private String[] player1NewProperty;
    private String[] player2NewProperty;
    private List<Integer> player1NewPropertyIndex;
    private List<Integer> player2NewPropertyIndex;

    public TradeOutputData(Boolean tradeSuccess, String tradeMessage, int player1Index, int player2Index,
                           int player1NewMoney, int player2NewMoney, String[] player1NewProperty,
                           String[] player2NewProperty, List<Integer> player1NewPropertyIndex, List<Integer> player2NewPropertyIndex) {
        this.tradeSuccess = tradeSuccess;
        this.tradeMessage = tradeMessage;
        this.player1Index = player1Index;
        this.player2Index = player2Index;
        this.player1NewMoney = player1NewMoney;
        this.player2NewMoney = player2NewMoney;
        this.player1NewProperty = player1NewProperty;
        this.player2NewProperty = player2NewProperty;
        this.player1NewPropertyIndex = player1NewPropertyIndex;
        this.player2NewPropertyIndex = player2NewPropertyIndex;
    }

    //Getter and Setter Methods
    public boolean getTradeSuccess() {
        return tradeSuccess;
    }
    public String getTradeMessage() {return tradeMessage;}
    public int getPlayer1Index() {return player1Index;}
    public int getPlayer2Index() {return player2Index;}
    public int getPlayer1NewMoney() {return player1NewMoney;}
    public int getPlayer2NewMoney() {return player2NewMoney;}
    public String[] getPlayer1NewProperty() {return player1NewProperty;}
    public String[] getPlayer2NewProperty() {return player2NewProperty;}
    public List<Integer> getPlayer1NewPropertyIndex() {return player1NewPropertyIndex;}
    public List<Integer> getPlayer2NewPropertyIndex() {return player2NewPropertyIndex;}


    public void setTradeSuccess(Boolean tradeSuccess) {
        this.tradeSuccess = tradeSuccess;
    }
    public void setTradeMessage(String tradeMessage) {this.tradeMessage = tradeMessage;}
    public void setPlayer1Index(int player1Index) {this.player1Index = player1Index;}
    public void setPlayer2Index(int player2Index) {this.player2Index = player2Index;}
    public void setPlayer1NewMoney(int player1NewMoney) {this.player1NewMoney = player1NewMoney;}
    public void setPlayer2NewMoney(int player2NewMoney) {this.player2NewMoney = player2NewMoney;}
    public void setPlayer1NewProperty(String[] player1NewProperty) {this.player1NewProperty = player1NewProperty;}
    public void setPlayer2NewProperty(String[] player2NewProperty) {this.player2NewProperty = player2NewProperty;}

}



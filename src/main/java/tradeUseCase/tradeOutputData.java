package tradeUseCase;
//

public class tradeOutputData {
    private Boolean tradeSuccess;
    private String tradeMessage;
    // String playerLocation;

    public tradeOutputData(Boolean tradeSuccess, String tradeMessage) {
         this.tradeSuccess = tradeSuccess;
         this.tradeMessage = tradeMessage;

    }

    //Getter and Setter Methods
    public boolean getTradeSuccess() {
        return tradeSuccess;
    }
    public String getTradeMessage() {return tradeMessage;}

    public void setTradeSuccess(Boolean tradeSuccess) {
        this.tradeSuccess = tradeSuccess;
    }
    public void setTradeMessage(String tradeMessage) {this.tradeMessage = tradeMessage;}

}



package Trade;

public class TradeOutputData {
    //change to private`
    Boolean tradeSuccess;
    // String playerLocation;

    public TradeOutputData(Boolean tradeSuccess, String tradeMessage) {
         this.tradeSuccess = tradeSuccess;


    }

    //Getter and Setter Methods
    public boolean getTradeSuccess() {
        return tradeSuccess;
    }


    public void setTradeSuccess(Boolean tradeSuccess) {
        this.tradeSuccess = tradeSuccess;
    }

    public String getTradeMessage() {
        if (tradeSuccess) {
            return "Trade successful!";
        } else {
            return "Trade unsuccessful!";
        }
    }
}



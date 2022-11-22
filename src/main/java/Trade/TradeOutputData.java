package Trade;

public class TradeOutputData {
    Boolean tradeSuccess;
    // String playerLocation;

    public TradeOutputData(Boolean tradeSuccess) {
         this.tradeSuccess = tradeSuccess;
    }

    //Getter and Setter Methods
    public Boolean getTradeSuccess() {
        return tradeSuccess;
    }


    public void setTradeSuccess(Boolean tradeSuccess) {
        this.tradeSuccess = tradeSuccess;
    }

}



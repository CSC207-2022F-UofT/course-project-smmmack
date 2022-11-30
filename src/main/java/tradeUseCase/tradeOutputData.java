package tradeUseCase;

public class tradeOutputData {
    //change to private`
    Boolean tradeSuccess;
    // String playerLocation;

    public tradeOutputData(Boolean tradeSuccess, String tradeMessage) {
         this.tradeSuccess = tradeSuccess;


    }

    //Getter and Setter Methods
    public boolean getTradeSuccess() {
        return tradeSuccess;
    }

    /**
     *
     * @param tradeSuccess The boolean value that determines whether the trade was successful or not.
     */


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



package DrawCardUseCase;

public class DrawCardOutputData {
    String message;
    boolean isDrawSuccess;
    int playerIndex;
    int cashAmount;
    boolean isGainCash;
    public DrawCardOutputData(String message, boolean isDrawSuccess, int playerIndex, int cashAmount, boolean isGainCash) {
        this.message = message;
        this.isDrawSuccess = isDrawSuccess;
        this.playerIndex = playerIndex;
        this.cashAmount = cashAmount;
        this.isGainCash = isGainCash;
    }

    //getters
    public String getMessage() {return message;}
    public int getPlayerIndex(){return playerIndex;}
    public boolean getDrawSuccess() {return isDrawSuccess;}
    public int getCashAmount() {return cashAmount;}
    public boolean getIsGainCash() {return isGainCash;}

    //setters
    public void setMessage(String message) {
        this.message = message;
    }
    public void setDrawSuccess(boolean isDrawSuccess) {
        this.isDrawSuccess = isDrawSuccess;
    }

}

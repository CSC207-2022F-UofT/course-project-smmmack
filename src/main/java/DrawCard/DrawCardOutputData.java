package DrawCard;

public class DrawCardOutputData {
    String message;
    boolean isDrawSuccess;
    int playerIndex;
    int cash;
    boolean positive;
    public DrawCardOutputData(String message, boolean isDrawSuccess, int playerIndex, int cash, boolean positive) {
        this.message = message;
        this.isDrawSuccess = isDrawSuccess;
        this.playerIndex = playerIndex;
        this.cash = cash;
        this.positive = positive;
    }

    //getters
    public String getMessage() {
        return message;
    }
    public int getPlayerIndex(){return playerIndex;}
    public boolean getDrawSuccess() {return isDrawSuccess;}
    public int getCash() {return cash;}
    public boolean getPositive() {return positive;}

    //setters
    public void setMessage(String message) {
        this.message = message;
    }

    public void setDrawSuccess(boolean isDrawSuccess) { this.isDrawSuccess = isDrawSuccess;}

}

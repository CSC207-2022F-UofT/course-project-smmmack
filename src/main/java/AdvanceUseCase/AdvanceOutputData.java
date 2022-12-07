package AdvanceUseCase;

public class AdvanceOutputData {
    String advanceMessage;
    boolean isAdvanceSuccess;

    int playerLocation;

    int playerIndex;

    public AdvanceOutputData(String advanceMessage, boolean isAdvanceSuccess, int playerLocation, int playerIndex) {
        this.advanceMessage = advanceMessage;
        this.isAdvanceSuccess = isAdvanceSuccess;
        this.playerLocation = playerLocation;
        this.playerIndex = playerIndex;
    }

    //Getter and Setter Methods
    public String getAdvanceMessage() {
        return advanceMessage;
    }

    public boolean isAdvanceSuccess() {
        return isAdvanceSuccess;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public int getPlayerLocation() {
        return playerLocation;
    }

    public void setAdvanceMessage(String advanceMessage) {
        this.advanceMessage = advanceMessage;
    }

    public void setAdvanceSuccess(boolean advanceSuccess) {
        isAdvanceSuccess = advanceSuccess;
    }

    public void setPlayerLocation(int playerLocation) {
        this.playerLocation = playerLocation;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }
}


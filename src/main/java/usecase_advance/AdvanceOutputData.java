package usecase_advance;

public class AdvanceOutputData {
    String advanceMessage;
    boolean isAdvanceSuccess;

    int playerLocation;

    int playerIndex;

    boolean updateInputMap;

    public AdvanceOutputData(String advanceMessage, boolean isAdvanceSuccess, int playerLocation, int playerIndex,
                             boolean updateInputMap) {
        this.advanceMessage = advanceMessage;
        this.isAdvanceSuccess = isAdvanceSuccess;
        this.playerLocation = playerLocation;
        this.playerIndex = playerIndex;
        this.updateInputMap = updateInputMap;
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

    public boolean isUpdateInputMap() {
        return updateInputMap;
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

    public void setUpdateInputMap(boolean updateInputMap) {
        this.updateInputMap = updateInputMap;
    }
}


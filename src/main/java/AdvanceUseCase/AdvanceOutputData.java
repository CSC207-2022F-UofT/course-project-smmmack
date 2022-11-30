package AdvanceUseCase;

public class AdvanceOutputData {
    String advanceMessage;
    boolean isAdvanceSuccess;

    public AdvanceOutputData(String advanceMessage, boolean isAdvanceSuccess) {
        this.advanceMessage = advanceMessage;
        this.isAdvanceSuccess = isAdvanceSuccess;
    }

    //Getter and Setter Methods
    public String getAdvanceMessage() {
        return advanceMessage;
    }

    public boolean isAdvanceSuccess() {
        return isAdvanceSuccess;

    public void setAdvanceSuccess(boolean advanceSuccess) {
        isAdvanceSuccess = advanceSuccess;
    }
}


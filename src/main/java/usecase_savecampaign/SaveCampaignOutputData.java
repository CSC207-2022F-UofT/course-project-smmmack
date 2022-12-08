package usecase_savecampaign;

public class SaveCampaignOutputData {
    private String outputMessage;
    private boolean success;

    public SaveCampaignOutputData(boolean success, String outputMessage) {
        this.outputMessage = outputMessage;
        this.success = success;
    }

    //getters

    public String getOutputMessage() {
        return outputMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    //setters

    public void setOutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

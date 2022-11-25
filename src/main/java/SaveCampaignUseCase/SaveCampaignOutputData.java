package SaveCampaignUseCase;

public class SaveCampaignOutputData {
    private String outputMessage;

    public SaveCampaignOutputData(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    //getters

    public String getOutputMessage() {
        return outputMessage;
    }

    //setters

    public void setOutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }
}

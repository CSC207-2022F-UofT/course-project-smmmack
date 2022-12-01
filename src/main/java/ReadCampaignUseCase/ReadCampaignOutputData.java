package ReadCampaignUseCase;

public class ReadCampaignOutputData {
    private boolean success;
    private String message;

    public ReadCampaignOutputData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    //getters

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    //setters

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

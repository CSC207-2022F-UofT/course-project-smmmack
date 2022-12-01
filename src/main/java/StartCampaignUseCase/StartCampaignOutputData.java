package StartCampaignUseCase;

public class StartCampaignOutputData {
    private String message;

    private String nextMap;

    public StartCampaignOutputData(String message, String nextMap) {
        this.message = message;
        this.nextMap = nextMap;
    }

    //getters

    public String getMessage() {
        return message;
    }

    public String getNextMap() {
        return nextMap;
    }

    //setters

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNextMap(String nextMap) {
        this.nextMap = nextMap;
    }
}

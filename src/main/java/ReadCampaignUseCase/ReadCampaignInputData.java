package ReadCampaignUseCase;

public class ReadCampaignInputData {
    private String relativePath;

    public ReadCampaignInputData(String relativePath) {
        this.relativePath = relativePath;
    }

    //getters

    public String getRelativePath() {
        return relativePath;
    }

    //setters

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }
}

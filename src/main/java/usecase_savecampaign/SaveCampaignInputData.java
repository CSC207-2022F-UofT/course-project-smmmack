package usecase_savecampaign;

public class SaveCampaignInputData {
    private String relativePath;

    public SaveCampaignInputData(String relativePath) {
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

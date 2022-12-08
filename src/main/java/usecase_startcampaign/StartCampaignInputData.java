package usecase_startcampaign;

public class StartCampaignInputData {
    private String campaignName;

    public StartCampaignInputData() {
        this("Default Campaign");
    }

    public StartCampaignInputData(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }
}

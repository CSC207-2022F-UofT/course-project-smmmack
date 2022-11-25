package SaveCampaignUseCase;

public class SaveCampaignInputData {
    private String address;

    public SaveCampaignInputData(String address) {
        this.address = address;
    }

    //getters

    public String getAddress() {
        return address;
    }

    //setters

    public void setAddress(String address) {
        this.address = address;
    }
}

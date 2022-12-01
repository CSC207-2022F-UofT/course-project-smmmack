package ReadCampaignUseCase;

public class ReadCampaignInputData {
    private String address;

    public ReadCampaignInputData(String address) {
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

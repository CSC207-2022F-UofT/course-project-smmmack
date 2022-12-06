package ReadCampaignUseCase;

import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import StartCampaignUseCase.StartCampaignInputBoundary;
import StartCampaignUseCase.StartCampaignInputData;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadCampaignInteractor implements ReadCampaignInputBoundary {

    private CampaignAccess campaignAccess;
    private ReadCampaignOutputBoundary outputBoundary;
    private StartCampaignInputBoundary nextInputBoundary;

    @Override
    public void performAction(ReadCampaignInputData inputData) {
        String address = inputData.getAddress();
        try {
            FileInputStream fileStream = new FileInputStream(address);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            Campaign campaign = (Campaign) objectStream.readObject();
            objectStream.close();
            fileStream.close();
            String message = "You have successfully read game from: " + address;
            outputBoundary.performAction(new ReadCampaignOutputData(true, message));
            String campaignName = "campaign from file";
            nextInputBoundary.performAction(new StartCampaignInputData(campaignName));
        } catch (Exception e) {
            String message = "Unable to read game save from address " + address +
                    " because of exception (" + e.getClass() + "): " + e.getMessage();
            outputBoundary.performAction(new ReadCampaignOutputData(false, message));
        }
    }

    //getters

    public CampaignAccess getCampaignAccess() {
        return campaignAccess;
    }

    public ReadCampaignOutputBoundary getOutputBoundary() {
        return outputBoundary;
    }

    public StartCampaignInputBoundary getNextInputBoundary() {
        return nextInputBoundary;
    }

    //setters

    public void setOutputBoundary(ReadCampaignOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    public void setCampaignAccess(CampaignAccess campaignAccess) {
        this.campaignAccess = campaignAccess;
    }

    public void setNextInputBoundary(StartCampaignInputBoundary nextInputBoundary) {
        this.nextInputBoundary = nextInputBoundary;
    }
}

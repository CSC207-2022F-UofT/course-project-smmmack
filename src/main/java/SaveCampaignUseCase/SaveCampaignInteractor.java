package SaveCampaignUseCase;

import MainEntities.Campaign;
import MainEntities.CampaignAccess;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * This use case saves a campaign to a .ser file as an object. You may only save campaigns at the beginning of turns.
 * TODO: might use another input format: the user might input only a file name instead of the full address.
 */
public class SaveCampaignInteractor implements SaveCampaignInputBoundary {
    public static final String ROOT_PATH = "saves/";
    private CampaignAccess campaignAccess;
    private SaveCampaignOutputBoundary outputBoundary;

    public SaveCampaignInteractor() {

    }

    public SaveCampaignInteractor(CampaignAccess campaignAccess, SaveCampaignOutputBoundary outputBoundary) {
        this.campaignAccess = campaignAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void performAction(SaveCampaignInputData inputData) {
        String address = ROOT_PATH + inputData.getRelativePath();
        Campaign campaign = campaignAccess.getCampaign();
        //Save the campaign to the given address as a serializable object
        try {
            FileOutputStream fileStream = new FileOutputStream(address);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(campaign);
            objectStream.close();
            fileStream.close();
            String outputMessage = "You have successfully saved the game at: " + address;
            SaveCampaignOutputData outputData = new SaveCampaignOutputData(true, outputMessage);
            outputBoundary.performAction(outputData);
        } catch (IOException e) {
            String outputMessage = "Failed to save the game at: " + address +
                    " Because of IOException: " + e.getMessage();
            SaveCampaignOutputData outputData = new SaveCampaignOutputData(false, outputMessage);
            outputBoundary.performAction(outputData);
        }
    }

    //getters

    public CampaignAccess getCampaignAccess() {
        return campaignAccess;
    }

    public SaveCampaignOutputBoundary getOutputBoundary() {
        return outputBoundary;
    }

    //setters

    public void setCampaignAccess(CampaignAccess campaignAccess) {
        this.campaignAccess = campaignAccess;
    }

    public void setOutputBoundary(SaveCampaignOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }
}

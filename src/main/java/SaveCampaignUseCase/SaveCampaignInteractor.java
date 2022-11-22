package SaveCampaignUseCase;

import MainEntities.Campaign;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCampaignInteractor implements SaveCampaignInputBoundary {
    private Campaign campaign;
    private SaveCampaignOutputBoundary outputBoundary;

    public SaveCampaignInteractor(Campaign campaign, SaveCampaignOutputBoundary outputBoundary) {
        this.campaign = campaign;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void performAction(SaveCampaignInputData inputData) {
        String address = inputData.getAddress();
        //Save the campaign to the given address as a serializable object
        try {
            FileOutputStream fileStream = new FileOutputStream(address);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(campaign);
            objectStream.close();
            fileStream.close();
            String outputMessage = "You have successfully saved the game at: " + address;
            SaveCampaignOutputData outputData = new SaveCampaignOutputData(outputMessage);
            outputBoundary.performAction(outputData);
        } catch (IOException e) {
            String outputMessage = "Failed to save the game at: " + address +
                    "Because of IOException: " + e.getMessage();
            SaveCampaignOutputData outputData = new SaveCampaignOutputData(outputMessage);
            outputBoundary.performAction(outputData);
        }
    }

    //getters

    public Campaign getCampaign() {
        return campaign;
    }

    public SaveCampaignOutputBoundary getOutputBoundary() {
        return outputBoundary;
    }

    //setters

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public void setOutputBoundary(SaveCampaignOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }
}

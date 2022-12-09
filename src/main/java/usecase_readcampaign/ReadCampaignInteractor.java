package usecase_readcampaign;

import entities_main.Campaign;
import entities_main.CampaignAccess;
import usecase_startcampaign.StartCampaignInputBoundary;
import usecase_startcampaign.StartCampaignInputData;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadCampaignInteractor implements ReadCampaignInputBoundary {
    public static final String ROOT_PATH = "saves/";

    private CampaignAccess campaignAccess;
    private ReadCampaignOutputBoundary outputBoundary;
    private StartCampaignInputBoundary nextInputBoundary;

    @Override
    public void performAction(ReadCampaignInputData inputData) {
        String relativePath = inputData.getRelativePath();
        try {
            FileInputStream fileStream = new FileInputStream(ROOT_PATH + relativePath);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            Campaign campaign = (entities_main.Campaign) objectStream.readObject();
            campaignAccess.setCampaign(campaign);
            objectStream.close();
            fileStream.close();
            String message = "You have successfully read game from: " + relativePath;
            outputBoundary.performAction(new ReadCampaignOutputData(true, message));
            String campaignName = "campaign from file";
            nextInputBoundary.performAction(new StartCampaignInputData(campaignName));
        } catch (Exception e) {
            String message = "Unable to read game save from address " + ROOT_PATH + relativePath +
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

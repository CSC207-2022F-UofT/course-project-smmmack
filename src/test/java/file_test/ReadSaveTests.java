package file_test;

import MainEntities.Campaign;
import MainEntities.CampaignAccess;
import MainEntities.DefaultCampaignFactory;
import ReadCampaignUseCase.ReadCampaignInputData;
import ReadCampaignUseCase.ReadCampaignInteractor;
import SaveCampaignUseCase.SaveCampaignInputData;
import SaveCampaignUseCase.SaveCampaignInteractor;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.*;

public class ReadSaveTests {

    @Test
    public void testSaveCampaign() {
        String relativePath = "save_test.ser";
        int expectedCash = 254;
        SaveCampaignInteractor interactor = new SaveCampaignInteractor();
        CampaignAccess campaignAccess = new CampaignAccess();
        Campaign campaign = new DefaultCampaignFactory(4).create();
        campaign.getPlayerAt(0).setCash(expectedCash);
        campaignAccess.setCampaign(campaign);
        interactor.setCampaignAccess(campaignAccess);
        final Campaign[] savedCampaign = new Campaign[1];
        interactor.setOutputBoundary(outputData -> {
            try {
                File picture = new File("saves/save_test.ser");
                Assertions.assertTrue(picture.isFile());
                FileInputStream fileStream = new FileInputStream(SaveCampaignInteractor.ROOT_PATH + relativePath);
                ObjectInputStream objectStream = new ObjectInputStream(fileStream);
                savedCampaign[0] = (Campaign) objectStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        SaveCampaignInputData inputData = new SaveCampaignInputData(relativePath);
        interactor.performAction(inputData);

        Assertions.assertNotNull(savedCampaign[0]);
        int actualCash = savedCampaign[0].getPlayerAt(0).getCash();
        Assertions.assertEquals(expectedCash, actualCash);
    }

    @Test
    public void testReadCampaign() {
        String relativePath = "read_test.ser";
        int expectedCash = 254;
        ReadCampaignInteractor interactor = new ReadCampaignInteractor();
        CampaignAccess campaignAccess = new CampaignAccess();
        interactor.setCampaignAccess(campaignAccess);
        interactor.setOutputBoundary(outputData -> System.out.println("output boundary called"));

        try {
            Campaign campaign = new DefaultCampaignFactory(4).create();
            campaign.getPlayerAt(0).setCash(expectedCash);
            FileOutputStream fileStream = new FileOutputStream(SaveCampaignInteractor.ROOT_PATH + relativePath);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(campaign);
            objectStream.close();
            fileStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReadCampaignInputData inputData = new ReadCampaignInputData(relativePath);
        interactor.performAction(inputData);
        Campaign campaign = campaignAccess.getCampaign();
        Assertions.assertNotNull(campaign);
        int actualCash = campaign.getPlayerAt(0).getCash();
        Assertions.assertEquals(expectedCash, actualCash);
    }
}

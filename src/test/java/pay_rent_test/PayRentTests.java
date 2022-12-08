package pay_rent_test;

import MainEntities.*;
import Properties.NormalProperty;
import Properties.Property;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class PayRentTests {

    /**
     * Tests PayRent when a rentee lands on a property with house level 0
     * @throws Exception if there is an error
     */
    @Test
    public void PayRentTestsNormalPropertyBaseRent() throws Exception {

        Campaign defaultCampaignFactory = new DefaultCampaignFactory(2).create();
        CampaignAccess campaignAccess = new CampaignAccess();
        campaignAccess.setCampaign(defaultCampaignFactory);

        Player player1 = campaignAccess.getCampaign().getPlayerCalled("p1");
        Player player2 = campaignAccess.getCampaign().getPlayerCalled("p2");

        Property land1 = campaignAccess.getCampaign().getPropertyByAbbr("L1");
        land1.setOwner(player2);

        player1.setLocation(1);

        PayRent.PayRentInputData payRentInputData = new PayRent.PayRentInputData();
        PayRent.PayRentOutputBoundary payRentOutputBoundary = new PayRent.PayRentOutputBoundary() {
            @Override
            public void performAction(String payRentOutputData) {}
        };

        PayRent.PayRentInteractor payRentInteractor = new PayRent.PayRentInteractor(payRentOutputBoundary, campaignAccess);
        payRentInteractor.performAction(payRentInputData);

        int player1CashAfter = player1.getCash();
        int player2CashAfter = player2.getCash();

        Assertions.assertEquals(player1CashAfter, 998);
        Assertions.assertEquals(player2CashAfter, 1002);


    }

    /**
     * Test PayRent when the rentee lands on a property where the house level is 1
     * @throws Exception if there is an error
     */
    @Test
    public void PayRentTestsNormalPropertyHouseUpOne() throws Exception {

        Campaign defaultCampaignFactory = new DefaultCampaignFactory(2).create();
        CampaignAccess campaignAccess = new CampaignAccess();
        campaignAccess.setCampaign(defaultCampaignFactory);

        Player player1 = campaignAccess.getCampaign().getPlayerCalled("p1");
        Player player2 = campaignAccess.getCampaign().getPlayerCalled("p2");

        NormalProperty land1 = (NormalProperty) campaignAccess.getCampaign().getPropertyByAbbr("L1");
        land1.setOwner(player2);
        land1.houseUp();

        player1.setLocation(1);

        PayRent.PayRentInputData payRentInputData = new PayRent.PayRentInputData();
        PayRent.PayRentOutputBoundary payRentOutputBoundary = new PayRent.PayRentOutputBoundary() {
            @Override
            public void performAction(String payRentOutputData) {}
        };

        PayRent.PayRentInteractor payRentInteractor = new PayRent.PayRentInteractor(payRentOutputBoundary, campaignAccess);
        payRentInteractor.performAction(payRentInputData);

        int player1CashAfter = player1.getCash();
        int player2CashAfter = player2.getCash();

        Assertions.assertEquals(player1CashAfter, 990);
        Assertions.assertEquals(player2CashAfter, 1010);

    }

    /**
     * Test PayRent when the rentee lands on a property where the house level is 1
     * @throws Exception if there is an error
     */
    @Test
    public void PayRentTestsNormalPropertyHouseUpTwo() throws Exception {

        Campaign defaultCampaignFactory = new DefaultCampaignFactory(2).create();
        CampaignAccess campaignAccess = new CampaignAccess();
        campaignAccess.setCampaign(defaultCampaignFactory);

        Player player1 = campaignAccess.getCampaign().getPlayerCalled("p1");
        Player player2 = campaignAccess.getCampaign().getPlayerCalled("p2");

        NormalProperty land1 = (NormalProperty) campaignAccess.getCampaign().getPropertyByAbbr("L1");
        land1.setOwner(player2);
        land1.houseUp();
        land1.houseUp();

        player1.setLocation(1);

        PayRent.PayRentInputData payRentInputData = new PayRent.PayRentInputData();
        PayRent.PayRentOutputBoundary payRentOutputBoundary = new PayRent.PayRentOutputBoundary() {
            @Override
            public void performAction(String payRentOutputData) {}
        };

        PayRent.PayRentInteractor payRentInteractor = new PayRent.PayRentInteractor(payRentOutputBoundary, campaignAccess);
        payRentInteractor.performAction(payRentInputData);

        int player1CashAfter = player1.getCash();
        int player2CashAfter = player2.getCash();

        Assertions.assertEquals(player1CashAfter, 970);
        Assertions.assertEquals(player2CashAfter, 1030);

    }

    /**
     * Test PayRent when the rentee has negative cash and lands on a property where the house level is 5
     * @throws Exception if there is an error
     */
    @Test
    public void PayRentTestsNegativeCashNormalPropertyHouseUpFive() throws Exception {

        Campaign defaultCampaignFactory = new DefaultCampaignFactory(2).create();
        CampaignAccess campaignAccess = new CampaignAccess();
        campaignAccess.setCampaign(defaultCampaignFactory);

        Player player1 = campaignAccess.getCampaign().getPlayerCalled("p1");
        Player player2 = campaignAccess.getCampaign().getPlayerCalled("p2");
        player1.setCash(-50);

        NormalProperty land1 = (NormalProperty) campaignAccess.getCampaign().getPropertyByAbbr("L1");
        land1.setOwner(player2);
        land1.houseUp();
        land1.houseUp();
        land1.houseUp();
        land1.houseUp();
        land1.houseUp();

        player1.setLocation(1);

        PayRent.PayRentInputData payRentInputData = new PayRent.PayRentInputData();
        PayRent.PayRentOutputBoundary payRentOutputBoundary = new PayRent.PayRentOutputBoundary() {
            @Override
            public void performAction(String payRentOutputData) {}
        };

        PayRent.PayRentInteractor payRentInteractor = new PayRent.PayRentInteractor(payRentOutputBoundary, campaignAccess);
        payRentInteractor.performAction(payRentInputData);

        int player1CashAfter = player1.getCash();
        int player2CashAfter = player2.getCash();

        Assertions.assertEquals(player1CashAfter, -300);
        Assertions.assertEquals(player2CashAfter, 1250);

    }

}

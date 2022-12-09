package pay_rent_test;

import entities_main.*;
import entities_properties.NormalProperty;
import entities_properties.Property;
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
        land1.assignOwnership(player2);

        player1.setLocation(1);

        usecase_payrent.PayRentInputData payRentInputData = new usecase_payrent.PayRentInputData();
        usecase_payrent.PayRentOutputBoundary payRentOutputBoundary = new usecase_payrent.PayRentOutputBoundary() {
            @Override
            public void performAction(String payRentOutputData) {}
        };

        usecase_payrent.PayRentInteractor payRentInteractor = new usecase_payrent.PayRentInteractor(payRentOutputBoundary, campaignAccess);
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
        land1.assignOwnership(player2);
        land1.houseUp();

        player1.setLocation(1);

        usecase_payrent.PayRentInputData payRentInputData = new usecase_payrent.PayRentInputData();
        usecase_payrent.PayRentOutputBoundary payRentOutputBoundary = new usecase_payrent.PayRentOutputBoundary() {
            @Override
            public void performAction(String payRentOutputData) {}
        };

        usecase_payrent.PayRentInteractor payRentInteractor = new usecase_payrent.PayRentInteractor(payRentOutputBoundary, campaignAccess);
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
        land1.assignOwnership(player2);
        land1.houseUp();
        land1.houseUp();

        player1.setLocation(1);

        usecase_payrent.PayRentInputData payRentInputData = new usecase_payrent.PayRentInputData();
        usecase_payrent.PayRentOutputBoundary payRentOutputBoundary = new usecase_payrent.PayRentOutputBoundary() {
            @Override
            public void performAction(String payRentOutputData) {}
        };

        usecase_payrent.PayRentInteractor payRentInteractor = new usecase_payrent.PayRentInteractor(payRentOutputBoundary, campaignAccess);
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
        player1.loseCash(-50);

        NormalProperty land1 = (NormalProperty) campaignAccess.getCampaign().getPropertyByAbbr("L1");
        land1.assignOwnership(player2);
        land1.houseUp();
        land1.houseUp();
        land1.houseUp();
        land1.houseUp();
        land1.houseUp();

        player1.setLocation(1);

        usecase_payrent.PayRentInputData payRentInputData = new usecase_payrent.PayRentInputData();
        usecase_payrent.PayRentOutputBoundary payRentOutputBoundary = new usecase_payrent.PayRentOutputBoundary() {
            @Override
            public void performAction(String payRentOutputData) {}
        };

        usecase_payrent.PayRentInteractor payRentInteractor = new usecase_payrent.PayRentInteractor(payRentOutputBoundary, campaignAccess);
        payRentInteractor.performAction(payRentInputData);

        int player1CashAfter = player1.getCash();
        int player2CashAfter = player2.getCash();

        Assertions.assertEquals(player1CashAfter, -300);
        Assertions.assertEquals(player2CashAfter, 1250);

    }

    /**
     * Test PayRent when the rentee lands on a property where the renter owns all the same coloured property of that the
     * property the rentee landed on
     * @throws Exception if there is an error
     */
    @Test
    public void PayRentTestsSameColouredProperty() throws Exception {

        Campaign defaultCampaignFactory = new DefaultCampaignFactory(2).create();
        CampaignAccess campaignAccess = new CampaignAccess();
        campaignAccess.setCampaign(defaultCampaignFactory);

        Player player1 = campaignAccess.getCampaign().getPlayerCalled("p1");
        Player player2 = campaignAccess.getCampaign().getPlayerCalled("p2");

        NormalProperty land1 = (NormalProperty) campaignAccess.getCampaign().getPropertyByAbbr("L1");
        NormalProperty land2 = (NormalProperty) campaignAccess.getCampaign().getPropertyByAbbr("L2");
        land1.assignOwnership(player2);
        land2.assignOwnership(player2);

        player1.setLocation(1);

        usecase_payrent.PayRentInputData payRentInputData = new usecase_payrent.PayRentInputData();
        usecase_payrent.PayRentOutputBoundary payRentOutputBoundary = new usecase_payrent.PayRentOutputBoundary() {
            @Override
            public void performAction(String payRentOutputData) {}
        };

        usecase_payrent.PayRentInteractor payRentInteractor = new usecase_payrent.PayRentInteractor(payRentOutputBoundary, campaignAccess);
        payRentInteractor.performAction(payRentInputData);

        int player1CashAfter = player1.getCash();
        int player2CashAfter = player2.getCash();

        Assertions.assertEquals(player1CashAfter, 996);
        Assertions.assertEquals(player2CashAfter, 1004);

    }



}

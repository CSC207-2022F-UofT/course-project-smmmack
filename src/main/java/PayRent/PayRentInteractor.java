package PayRent;

import MainEntities.CampaignAccess;
import MainEntities.Player;
import Tiles.PropertyTile;
import Tiles.Tile;

public class PayRentInteractor implements PayRent.PayRentInputBoundary {

    private PayRent.PayRentOutputBoundary payRentOutputBoundary;
    private CampaignAccess campaignAccess;

    /**
     * Constructor for PayRentInteractor
     * @param payRentOutputBoundary output boundary
     */
    public PayRentInteractor(PayRent.PayRentOutputBoundary payRentOutputBoundary, CampaignAccess campaignAccess) {
        this.payRentOutputBoundary = payRentOutputBoundary;
        this.campaignAccess = campaignAccess;
    }

    /**
     *
     * @param payRentInputData input data for PayRent
     */
    @Override
    public void performAction(PayRentInputData payRentInputData) throws Exception {

        Player rentee = campaignAccess.getCampaign().getCurrentPlayer();
        Tile propertyLandedOn = campaignAccess.getCampaign().getTileUnderPlayer(rentee);
        Player renter = ((PropertyTile) propertyLandedOn).getProperty().getOwner();
        int rentMoney = ((PropertyTile) propertyLandedOn).getProperty().getRent(rentee);

        rentee.loseCash(rentMoney);
        renter.gainCash(rentMoney);

        String outputMessage = rentee.getName() + " paid $" + rentMoney + "of rent money to " + renter.getName();

        int renteeIndex = campaignAccess.getCampaign().getCurrPlayerIndex();

        int renterIndex = campaignAccess.getCampaign().getPlayerIndex(renter);

        String outputData = renteeIndex+ "@" + renterIndex + "@" + rentee.getCash() + "@" + renter.getCash() + "@" +
                outputMessage;

        PayRent.PayRentOutputData payRentOutputData = new PayRent.PayRentOutputData(outputData);


        payRentOutputBoundary.performAction(String.valueOf(payRentOutputData));


    }

    // getters
    public PayRent.PayRentOutputBoundary getPayRentOutputBoundary(){
        return payRentOutputBoundary;
    }

    // setters
    public void setPayRentOutputBoundary(PayRent.PayRentOutputBoundary payRentOutputBoundary){
        this.payRentOutputBoundary = payRentOutputBoundary;
    }

}

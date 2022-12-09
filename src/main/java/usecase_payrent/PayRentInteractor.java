package usecase_payrent;

import entities_main.CampaignAccess;
import entities_main.Player;
import entities_tiles.PropertyTile;
import entities_tiles.Tile;

public class PayRentInteractor implements usecase_payrent.PayRentInputBoundary {

    private PayRentOutputBoundary payRentOutputBoundary;
    private CampaignAccess campaignAccess;
    private Player rentee;
    private Player renter;
    private Tile propertyLandedOn;
    private int rentMoney;

    public PayRentInteractor(){}

    /**
     * Constructor for PayRentInteractor
     * @param payRentOutputBoundary output boundary
     * @param campaignAccess all information about the game: the board, players, etc.
     */
    public PayRentInteractor(usecase_payrent.PayRentOutputBoundary payRentOutputBoundary, CampaignAccess campaignAccess) {
        this.payRentOutputBoundary = payRentOutputBoundary;
        this.campaignAccess = campaignAccess;
        this.rentee = campaignAccess.getCampaign().getCurrentPlayer();
        this.propertyLandedOn = campaignAccess.getCampaign().getTileUnderPlayer(rentee);
        this.renter = ((PropertyTile) propertyLandedOn).getProperty().getOwner();
        this.rentMoney = ((PropertyTile) propertyLandedOn).getProperty().getRent(rentee);
    }

    /**
     *
     * @param payRentInputData input data for PayRent, this is empty
     */
    @Override
    public void performAction(PayRentInputData payRentInputData) throws Exception {

        rentee.loseCash(rentMoney);
        renter.gainCash(rentMoney);

        String outputMessage = rentee.getName() + " paid $" + rentMoney + "of rent money to " + renter.getName();

        int renteeIndex = campaignAccess.getCampaign().getCurrPlayerIndex();

        int renterIndex = campaignAccess.getCampaign().getPlayerIndex(renter);

        String outputData = renteeIndex+ "@" + renterIndex + "@" + rentee.getCash() + "@" + renter.getCash() + "@" +
                outputMessage;

        usecase_payrent.PayRentOutputData payRentOutputData = new usecase_payrent.PayRentOutputData(outputData);


        payRentOutputBoundary.performAction(String.valueOf(payRentOutputData));


    }

    // getters
    public usecase_payrent.PayRentOutputBoundary getPayRentOutputBoundary(){
        return payRentOutputBoundary;
    }
    public CampaignAccess getCampaignAccess(){
        return this.campaignAccess;
    }
    public Player getRentee(){
        return this.rentee;
    }
    public Player getRenter(){
        return this.renter;
    }

    public Tile getPropertyLandedOn(){
        return this.propertyLandedOn;
    }

    public int getRentMoney(){
        return this.rentMoney;
    }

    // setters
    public void setPayRentOutputBoundary(usecase_payrent.PayRentOutputBoundary payRentOutputBoundary){
        this.payRentOutputBoundary = payRentOutputBoundary;
    }

    public void setCampaignAccess(CampaignAccess campaignAccess){
        this.campaignAccess = campaignAccess;
    }

    public void setRentee(Player rentee){
        this.rentee = rentee;
    }

    public void setRenter(Player renter){
        this.renter = renter;
    }

    public void setTile(Tile propertyLandedOn){
        this.propertyLandedOn = propertyLandedOn;
    }

    public void setRentMoney(int rentMoney){
        this.rentMoney = rentMoney;
    }

}

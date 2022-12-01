package PayRent;

import MainEntities.Player;
import Properties.Property;

public class PayRentInteractor implements PayRentInputBoundary{

    private PayRentOutputBoundary payRentOutputBoundary;
    private final Player rentee;
    private final Player renter;
    private final Property propertyLandedOn;

    /**
     * Constructor for PayRentInteractor
     * @param payRentOutputBoundary output boundary
     * @param rentee the player who lands on a property
     * @param renter the player who owes the propety rentee landed on
     * @param propertyLandedOn the property that rentee landed on
     */
    public PayRentInteractor(PayRentOutputBoundary payRentOutputBoundary, Player rentee, Player renter,
                             Property propertyLandedOn) {
        this.payRentOutputBoundary = payRentOutputBoundary;
        this.rentee = rentee;
        this.renter = renter;
        this.propertyLandedOn = propertyLandedOn;
    }

    /**
     * Update the payRentMessage in payRentOutputBoundary based on different scenarios.
     * @param payRentInputData input data for PayRent
     */
    @Override
    public void performAction(PayRentInputData payRentInputData) {

        // set the input data
        payRentInputData.setRentee(rentee.getName());
        payRentInputData.setRenteeCash(rentee.getCash());
        payRentInputData.setRenter(renter.getName());
        payRentInputData.setRenterCash(renter.getCash());
        payRentInputData.setPropertyLandedOn(propertyLandedOn.getAbbreviation());
        payRentInputData.setRentMoney(propertyLandedOn.getRent(rentee));
        payRentInputData.setIsMortgaged(propertyLandedOn.isMortgaged());

        if(!payRentInputData.getConfirmPayRent()){
            String outputMessage = "Please make sure you have enough cash before you confirm to pay rent. " +
                    "You can sell your asses to get more cash or declare bankruptcy.";
            PayRentOutputData payRentOutputData = new PayRentOutputData(outputMessage);
            payRentOutputBoundary.payRentMessage(false, 0,0, payRentOutputData);
        } else if(payRentInputData.getIsMortgaged()){ // if the property is mortgaged
            String outputMessage = "No rent is paid as this property is mortgaged.";
            PayRentOutputData payRentOutputData = new PayRentOutputData(outputMessage);
            payRentOutputBoundary.payRentMessage(false, 0,0, payRentOutputData);
        } else if(payRentInputData.getRenteeCash() < payRentInputData.getRentMoney()){
            // if the rentee does not have enough money to pay the rent
            String outputMessage = "Player does not have enough money to pay the rent.";
            PayRentOutputData payRentOutputData = new PayRentOutputData(outputMessage);
            payRentOutputBoundary.payRentMessage(false, 0, 0, payRentOutputData);
        } else if (payRentInputData.getRenteeCash() > payRentInputData.getRentMoney()){
            // if the rentee has enough money to pay the rent

            int rentMoney = propertyLandedOn.getRent(rentee);

            rentee.loseCash(rentMoney);
            payRentInputData.setRenteeCash(rentee.getCash());
            renter.gainCash(rentMoney);
            payRentInputData.setRenterCash(renter.getCash());

            String outputMessage = payRentInputData.getRentee() + " paid " +
                    payRentInputData.getRentMoney() + "of rent money to " + payRentInputData.getRenter();

            PayRentOutputData payRentOutputData = new PayRentOutputData(outputMessage);

            payRentOutputBoundary.payRentMessage(false, payRentInputData.getRenteeCash(),
                    payRentInputData.getRenterCash(), payRentOutputData);

        } else{ // if something else happens
            String outputMessage = "Error. Please try again.";
            PayRentOutputData payRentOutputData = new PayRentOutputData(outputMessage);
            payRentOutputBoundary.payRentMessage(false, 0, 0, payRentOutputData);
        }

    }

    // getters
    public PayRentOutputBoundary getPayRentOutputBoundary(){
        return payRentOutputBoundary;
    }

    // setters
    public void setPayRentOutputBoundary(PayRentOutputBoundary payRentOutputBoundary){
        this.payRentOutputBoundary = payRentOutputBoundary;
    }

}

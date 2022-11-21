package PayRent;

import MainEntities.Player;
import Properties.Property;

public class PayRentInteractor implements PayRentInputBoundary{

    final PayRentOutputBoundary payRentOutputBoundary;
    final PayRentPresenter payRentPresenter;

    public PayRentInteractor(PayRentOutputBoundary payRentOutputBoundary,PayRentPresenter payRentPresenter) {
        this.payRentOutputBoundary = payRentOutputBoundary;
        this.payRentPresenter = payRentPresenter;
    }

    /**
     * return false if the property has no owner, the property is mortgaged or if the rentee does not have enough money
     * to pay the rent and return true if paying rent is successful

     * @param rentee player who landed on a property
     * @param propertyLandedOn property that the player landed on
     * @return false if rentee did not pay rent money and true if rentee paid the rent money
     */
    public boolean payRentMoney(Player rentee, Property propertyLandedOn){


        // need to ask how getRent(Player) is implemented and based on that, I might need to change this
        if (propertyLandedOn.getOwner() == Player.OWNERLESS ||
                rentee.getCash() < propertyLandedOn.getRent(rentee)){
            return false;
        }

        if (propertyLandedOn.isMortgaged()){
            return true;
        }

        rentee.setCash(rentee.getCash() - propertyLandedOn.getRent(rentee));
        return true;

    }

    /**
     * For prepareFailView:
     * - If the player does not have enough money to pay the rent, send a fail message return("player does not have
     * enough money to pay the rent")

     * For prepareSuccessView:
     * - if the property is mortgaged, no rent is paid
     * - otherwise, return a success message that Player has paid the rent

     * @param payRentInputData input data
     * @return returns a string based on whether payRentMoney was successful or not
     */
    @Override
    public PayRentOutputData create(PayRentInputData payRentInputData) {

        if (payRentInputData.getRentee().getCash() < payRentInputData.getRentMoney()){
            return payRentOutputBoundary.prepareFailView("Player does have enough money to pay the rent.");
        }

        if(payRentInputData.getIsMortgaged()){
            return payRentOutputBoundary.prepareSuccessView(
                    "No rent is paid as this property is mortgaged.");
        }

        return payRentOutputBoundary.prepareSuccessView(payRentInputData.getRentee() + " paid " +
                payRentInputData.getRentMoney() + "of rent money to " + payRentInputData.getRenter());
    }
}

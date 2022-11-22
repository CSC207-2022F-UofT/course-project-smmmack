package PayRent;

public class PayRentInteractor implements PayRentInputBoundary{

    final PayRentOutputBoundary payRentOutputBoundary;
    final PayRentPresenter payRentPresenter;

    public PayRentInteractor(PayRentOutputBoundary payRentOutputBoundary,PayRentPresenter payRentPresenter) {
        this.payRentOutputBoundary = payRentOutputBoundary;
        this.payRentPresenter = payRentPresenter;
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

        payRentInputData.getRentee().setCash(payRentInputData.getRentee().getCash() -
                payRentInputData.getPropertyLandedOn().getRent(payRentInputData.getRentee()));
        return payRentOutputBoundary.prepareSuccessView(payRentInputData.getRentee() + " paid " +
                payRentInputData.getRentMoney() + "of rent money to " + payRentInputData.getRenter());
    }
}

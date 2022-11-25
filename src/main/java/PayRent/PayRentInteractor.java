package PayRent;

public class PayRentInteractor implements PayRentInputBoundary{

    private PayRentOutputBoundary payRentOutputBoundary;

    public PayRentInteractor(PayRentOutputBoundary payRentOutputBoundary) {
        this.payRentOutputBoundary = payRentOutputBoundary;
    }

    /**
     *
     * @param payRentInputData input data for PayRent
     */
    @Override
    public void create(PayRentInputData payRentInputData) {

        if (payRentInputData.getRentee().getCash() < payRentInputData.getRentMoney()){
            String outputMessage = "Player does not have enough money to pay the rent.";
            PayRentOutputData payRentOutputData = new PayRentOutputData(outputMessage);
            payRentOutputBoundary.payRentMessage(payRentOutputData);
        }

        if(payRentInputData.getIsMortgaged()){
            String outputMessage = "No rent is paid as this property is mortgaged.";
            PayRentOutputData payRentOutputData = new PayRentOutputData(outputMessage);
            payRentOutputBoundary.payRentMessage(payRentOutputData);
        }

        // may need to change this part based on how getRent() is implemented
        payRentInputData.getRentee().setCash(payRentInputData.getRentee().getCash() -
                payRentInputData.getPropertyLandedOn().getRent(payRentInputData.getRentee()));
        String outputMessage = payRentInputData.getRentee() + " paid " +
                payRentInputData.getRentMoney() + "of rent money to " + payRentInputData.getRenter();
        PayRentOutputData payRentOutputData = new PayRentOutputData(outputMessage);
        payRentOutputBoundary.payRentMessage(payRentOutputData);

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

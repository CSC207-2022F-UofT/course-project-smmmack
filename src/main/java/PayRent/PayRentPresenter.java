package PayRent;

public class PayRentPresenter implements PayRentOutputBoundary{


    @Override
    public void payRentMessage(PayRentOutputData payRentOutputData) {
        String message = payRentOutputData.getOutputMessage();
        // Will update the view model to add the output message to the command lines later
    }

}

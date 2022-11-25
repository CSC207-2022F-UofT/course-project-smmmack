package PayRent;

public class PayRentPresenter implements PayRentOutputBoundary{


    @Override
    public void payRentMessage(PayRentOutputData payRentOutputData) {
        String message = payRentOutputData.getOutputMessage();
    }
}

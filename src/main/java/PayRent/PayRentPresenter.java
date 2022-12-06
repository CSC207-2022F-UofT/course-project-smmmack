package PayRent;

public class PayRentPresenter implements PayRentOutputBoundary{


    @Override
    public PayRentOutputData prepareSuccessView(String successMessage) {
        return null;
    }

    @Override
    public PayRentOutputData prepareFailView(String error) {
        return null;
    }
}

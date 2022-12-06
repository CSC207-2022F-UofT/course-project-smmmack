package PayRent;

public interface PayRentOutputBoundary {

    PayRentOutputData prepareSuccessView(String successMessage);

    PayRentOutputData prepareFailView(String error);

}

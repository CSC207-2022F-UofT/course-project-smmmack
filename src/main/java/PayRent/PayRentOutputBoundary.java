package PayRent;

public interface PayRentOutputBoundary {

    void payRentMessage(boolean paidRent, int renteeCash, int renterCash, PayRentOutputData payRentOutputData);

}

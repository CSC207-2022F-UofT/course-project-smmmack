package PayRent;

public interface PayRentOutputBoundary {

    void payRentMessage(int renteeIndex, int renterIndex, int renteeCash, int renterCash, PayRent.PayRentOutputData payRentOutputData);

}

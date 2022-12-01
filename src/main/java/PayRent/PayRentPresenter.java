package PayRent;

import ViewModel.CommandLineViewModel;
import ViewModel.PlayerViewModel;

/**
 * This class updates the view models for the PlayerViewModel and CommandLineViewModel
 */
public class PayRentPresenter implements PayRentOutputBoundary{

    private PlayerViewModel renteePlayerViewModel;
    private PlayerViewModel renterPlayerViewModel;
    private CommandLineViewModel commandLineViewModel;

    public PayRentPresenter(PlayerViewModel renteePlayerViewModel, PlayerViewModel renterPlayerViewModel,
                            CommandLineViewModel commandLineViewModel){

        this.renteePlayerViewModel = renteePlayerViewModel;
        this.renterPlayerViewModel = renterPlayerViewModel;
        this.commandLineViewModel = commandLineViewModel;

    }

    /**
     * Send a message to update the PlayerViewModel and CommandLineViewModel
     * @param paidRent the amount of rent money the rentee paid
     * @param renteeCash the amount of cash the rentee has
     * @param renterCash the amount of cash the renter has
     * @param payRentOutputData output data that is going to be displayed
     */
    @Override
    public void payRentMessage(boolean paidRent, int renteeCash, int renterCash, PayRentOutputData payRentOutputData) {

        String message = payRentOutputData.getOutputMessage();

        if (paidRent){
            renteePlayerViewModel.setCash(renteeCash);
            renterPlayerViewModel.setCash(renterCash);
            commandLineViewModel.setMessage(message);
            commandLineViewModel.setType("output");
        } else{
            commandLineViewModel.setMessage(message);
            commandLineViewModel.setType("output");
        }

    }


}

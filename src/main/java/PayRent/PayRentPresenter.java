package PayRent;

import ViewModel.CommandPanelViewModel;
import ViewModel.PlayerViewModel;

/**
 * This class updates the view models for the PlayerViewModel and CommandLineViewModel
 */
public class PayRentPresenter implements PayRentOutputBoundary{

    PlayerViewModel renteePlayerViewModel;
    PlayerViewModel renterPlayerViewModel;
    CommandPanelViewModel commandPanelViewModel;

    public PayRentPresenter(PlayerViewModel renteePlayerViewModel, PlayerViewModel renterPlayerViewModel,
                            CommandPanelViewModel commandPanelViewModel){

        this.renteePlayerViewModel = renteePlayerViewModel;
        this.renterPlayerViewModel = renterPlayerViewModel;
        this.commandPanelViewModel = commandPanelViewModel;

    }

    /**
     * Send a message to update the PlayerViewModel and CommandPanelViewModel
     * @param renteeCash the amount of cash the rentee has
     * @param renterCash the amount of cash the renter has
     * @param payRentOutputData output data that is going to be displayed
     */
    @Override
    public void payRentMessage(int renteeCash, int renterCash, PayRent.PayRentOutputData payRentOutputData) {

        String message = payRentOutputData.getOutputMessage();
        renteePlayerViewModel.setCash(renteeCash);
        renterPlayerViewModel.setCash(renterCash);
        commandPanelViewModel.appendCommandLine("output",message);

    }


}

package PayRent;

import ViewModel.CommandLineViewModel;
import ViewModel.PlayerViewModel;

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

package PayRent;

import ViewModel.*;

/**
 * This class updates the view models for the PlayerViewModel and CommandLineViewModel
 */
public class PayRentPresenter implements PayRentOutputBoundary{

    PlayerPanelViewModel playerPanelViewModel;
    CommandPanelViewModel commandPanelViewModel;

    public PayRentPresenter(){}


    public PayRentPresenter(PlayerPanelViewModel playerPanelViewModel, CommandPanelViewModel commandPanelViewModel){

        this.playerPanelViewModel = playerPanelViewModel;
        this.commandPanelViewModel = commandPanelViewModel;

    }

    /**
     * Send a message to update the PlayerViewModel and CommandPanelViewModel
     * @param payRentOutputData a string of output data that needs to be displayed/changed in the commlandline and
     *                          viewmodel
     */
    @Override
    public void performAction(String payRentOutputData) {

        String[] splitPayRentOutputData = payRentOutputData.split("@");

        int renteeIndex = Integer.parseInt(splitPayRentOutputData[0]);
        int renterIndex = Integer.parseInt(splitPayRentOutputData[1]);
        int renteeCash = Integer.parseInt(splitPayRentOutputData[2]);
        int renterCash = Integer.parseInt(splitPayRentOutputData[3]);
        String message = splitPayRentOutputData[4];

        playerPanelViewModel.getPlayerVMAt(renteeIndex).setCash(renteeCash);
        playerPanelViewModel.getPlayerVMAt(renterIndex).setCash(renterCash);
        playerPanelViewModel.notifyListeners();
        commandPanelViewModel.appendOutput(message);
        commandPanelViewModel.notifyListeners();

    }

    // getters

    public PlayerPanelViewModel getPlayerPanelViewModel() {
        return this.playerPanelViewModel;
    }

    public CommandPanelViewModel getCommandPanelViewModel(){
        return this.commandPanelViewModel;
    }


    // setters
    public void setPlayerPanelViewModel(PlayerPanelViewModel playerPanelViewModel){
        this.playerPanelViewModel = playerPanelViewModel;
    }

    public void setCommandPanelViewModel(CommandPanelViewModel commandPanelViewModel){
        this.commandPanelViewModel = commandPanelViewModel;
    }


}

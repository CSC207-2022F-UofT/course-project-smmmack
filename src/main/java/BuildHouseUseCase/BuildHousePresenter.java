package BuildHouseUseCase;

import ViewModel.BoardPanelViewModel;
import ViewModel.CommandPanelViewModel;
import ViewModel.PlayerPanelViewModel;
import ViewModel.TileViewModel;

public class BuildHousePresenter implements BuildHouseOutputBoundary {
    CommandPanelViewModel commandPanelViewModel;
    PlayerPanelViewModel playerPanelViewModel;
    TileViewModel tileViewModel;
    BoardPanelViewModel boardPanelViewModel;

    public BuildHousePresenter(CommandPanelViewModel commandPanelViewModel,
                               PlayerPanelViewModel playerPanelViewModel,
                               TileViewModel tileViewModel,
                               BoardPanelViewModel boardPanelViewModel) {
        this.commandPanelViewModel = commandPanelViewModel;
        this.playerPanelViewModel = playerPanelViewModel;
        this.tileViewModel = tileViewModel;
        this.boardPanelViewModel = boardPanelViewModel;
    }

    public BuildHousePresenter(){

    }

    /**
     * Update the ViewModel's command panel about the successful or unsuccessful attempt to
     * build houses on the selected property; if successfully verified, update the ViewModel's tile
     * and set the new house level for the selected property.
     * @param buildHouseOutputData The notification indicating whether the player successfully built the
     *                             selected amount of houses on the selected property, verify in case of
     *                             successful attempt / unsuccessful attempt / error.
     */

    @Override
    public void performAction(BuildHouseOutputData buildHouseOutputData){
        String notification = buildHouseOutputData.getNotification();

        if (buildHouseOutputData.isVerification()){
            commandPanelViewModel.appendOutput(notification);
            TileViewModel propertySelected = boardPanelViewModel.getTileVMAt(buildHouseOutputData.getPropertyIndex());
            propertySelected.setHouseLevel(buildHouseOutputData.getHouseAmountToChange());
            int cash = buildHouseOutputData.playersCashAfterPurchase;
            playerPanelViewModel.getPlayerVMAt(buildHouseOutputData.playerIndex).setCash(cash);
            playerPanelViewModel.notifyListeners();
        } else {
            commandPanelViewModel.appendError(notification);
            playerPanelViewModel.notifyListeners();
        }
    }
}

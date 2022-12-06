package BuildHouseUseCase;

import ViewModel.CommandPanelViewModel;
import ViewModel.PlayerPanelViewModel;

public class BuildHousePresenter implements BuildHouseOutputBoundary {
    CommandPanelViewModel commandPanelViewModel;
    PlayerPanelViewModel playerPanelViewModel;

    public BuildHousePresenter(CommandPanelViewModel commandPanelViewModel,
                               PlayerPanelViewModel playerPanelViewModel) {
        this.commandPanelViewModel = commandPanelViewModel;
        this.playerPanelViewModel = playerPanelViewModel;
    }

    @Override
    public void performAction(BuildHouseOutputData buildHouseOutputData){
        String notification = buildHouseOutputData.getNotification();

        if (buildHouseOutputData.isVerification()){
            commandPanelViewModel.appendOutput(notification);
            playerPanelViewModel.notifyListeners();
        } else {
            commandPanelViewModel.appendError(notification);
            playerPanelViewModel.notifyListeners();
        }
    }
}

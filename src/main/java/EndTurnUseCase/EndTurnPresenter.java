package EndTurnUseCase;

import ViewModel.CommandPanelViewModel;
import ViewModel.InputMapDictionary;
import ViewModel.PlayerPanelViewModel;

public class EndTurnPresenter implements EndTurnOutputBoundary {
    private CommandPanelViewModel commandPanelVM;
    private PlayerPanelViewModel playerPanelVM;
    private InputMapDictionary mapDictionary;

    @Override
    public void performAction(EndTurnOutputData outputData) {
        commandPanelVM.appendOutput(outputData.getMessage());
        commandPanelVM.notifyListeners();

        playerPanelVM.getPlayerVMAt(outputData.getPlayerIndex()).setJailTurn(outputData.getPlayerJailTurn());
        playerPanelVM.notifyListeners();

        mapDictionary.setCurrentMapName(outputData.getNextState());
    }

    //setters

    public void setCommandPanelVM(CommandPanelViewModel commandPanelVM) {
        this.commandPanelVM = commandPanelVM;
    }

    public void setMapDictionary(InputMapDictionary mapDictionary) {
        this.mapDictionary = mapDictionary;
    }

    public void setPlayerPanelVM(PlayerPanelViewModel playerPanelVM) {
        this.playerPanelVM = playerPanelVM;
    }

    // getters

    public CommandPanelViewModel getCommandPanelVM() {
        return commandPanelVM;
    }

    public InputMapDictionary getMapDictionary() {
        return mapDictionary;
    }

    public PlayerPanelViewModel getPlayerPanelVM() {
        return playerPanelVM;
    }
}

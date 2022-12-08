package EndTurnUseCase;

import ViewModel.CommandPanelViewModel;
import ViewModel.InputMapDictionary;

public class EndTurnPresenter implements EndTurnOutputBoundary {
    private CommandPanelViewModel commandPanelVM;
    private InputMapDictionary mapDictionary;

    @Override
    public void performAction(EndTurnOutputData outputData) {
        commandPanelVM.appendOutput(outputData.getMessage());
        commandPanelVM.notifyListeners();

        mapDictionary.setCurrentMapName("before_move");
    }

    //setters

    public void setCommandPanelVM(CommandPanelViewModel commandPanelVM) {
        this.commandPanelVM = commandPanelVM;
    }

    public void setMapDictionary(InputMapDictionary mapDictionary) {
        this.mapDictionary = mapDictionary;
    }

    // getters

    public CommandPanelViewModel getCommandPanelVM() {
        return commandPanelVM;
    }

    public InputMapDictionary getMapDictionary() {
        return mapDictionary;
    }
}

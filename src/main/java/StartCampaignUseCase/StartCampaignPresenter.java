package StartCampaignUseCase;

import ViewModel.CommandPanelViewModel;
import ViewModel.InputMapDictionary;

public class StartCampaignPresenter implements StartCampaignOutputBoundary {
    private CommandPanelViewModel commandPanelVM;
    private InputMapDictionary mapDictionary;

    public StartCampaignPresenter(CommandPanelViewModel commandPanelVM, InputMapDictionary mapDictionary) {
        this.commandPanelVM = commandPanelVM;
        this.mapDictionary = mapDictionary;
    }

    @Override
    public void performAction(StartCampaignOutputData outputData) {
        commandPanelVM.appendOutput(outputData.getMessage());
        mapDictionary.setCurrentMapName(outputData.getNextMap());
        commandPanelVM.notifyListeners();
    }

    //getters

    public CommandPanelViewModel getCommandPanelVM() {
        return commandPanelVM;
    }

    public InputMapDictionary getMapDictionary() {
        return mapDictionary;
    }

    public void setCommandPanelVM(CommandPanelViewModel commandPanelVM) {
        this.commandPanelVM = commandPanelVM;
    }

    public void setMapDictionary(InputMapDictionary mapDictionary) {
        this.mapDictionary = mapDictionary;
    }
}

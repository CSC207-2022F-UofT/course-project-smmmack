package usecase_startdefcamp;

import viewmodel.CommandPanelViewModel;

public class StartDefCampPresenter implements StartDefCampOutputBoundary {

    private CommandPanelViewModel commandPanelVM;

    @Override
    public void performAction(StartDefCampOutputData outputData) {
        String message = outputData.getMessage();
        commandPanelVM.appendOutput(message);
        commandPanelVM.notifyListeners();
    }

    //getters

    public CommandPanelViewModel getCommandPanelVM() {
        return commandPanelVM;
    }

    //setters

    public void setCommandPanelVM(CommandPanelViewModel commandPanelVM) {
        this.commandPanelVM = commandPanelVM;
    }
}

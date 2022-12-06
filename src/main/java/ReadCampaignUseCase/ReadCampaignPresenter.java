package ReadCampaignUseCase;

import ViewModel.CommandPanelViewModel;

public class ReadCampaignPresenter implements ReadCampaignOutputBoundary {

    private CommandPanelViewModel commandPanelVM;

    @Override
    public void performAction(ReadCampaignOutputData outputData) {
        String message = outputData.getMessage();
        if (outputData.isSuccess()) commandPanelVM.appendOutput(message);
        else commandPanelVM.appendWarning(message);
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

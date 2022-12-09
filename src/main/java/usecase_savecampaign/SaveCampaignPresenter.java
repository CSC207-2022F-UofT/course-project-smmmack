package usecase_savecampaign;

import viewmodel.CommandPanelViewModel;

public class SaveCampaignPresenter implements SaveCampaignOutputBoundary{

    private CommandPanelViewModel commandPanelVM;

    public SaveCampaignPresenter() {

    }

    public SaveCampaignPresenter(CommandPanelViewModel commandPanelVM) {
        this.commandPanelVM = commandPanelVM;
    }

    @Override
    public void performAction(SaveCampaignOutputData outputData) {
        String outputMessage = outputData.getOutputMessage();
        if (outputData.isSuccess()) this.commandPanelVM.appendOutput(outputMessage);
        else this.commandPanelVM.appendWarning(outputMessage);
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

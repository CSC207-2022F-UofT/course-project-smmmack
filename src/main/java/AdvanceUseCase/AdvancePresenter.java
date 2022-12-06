package AdvanceUseCase;

import ViewModel.CommandLineViewModel;
import ViewModel.CommandPanelViewModel;

public class AdvancePresenter implements AdvanceOutputBoundary {

    CommandPanelViewModel commandPanelViewModel;

    public AdvancePresenter(CommandPanelViewModel commandPanelViewModel){
        this.commandPanelViewModel = commandPanelViewModel;
    }

    /**
     * Updates viewmodel's command panel with results of the advance.
     * @param outputData message telling player which tile they have advanced to or an error
     *                   message if the tile wasn't found.
     */
    @Override
    public void performAction(AdvanceOutputData outputData){
        String advanceMessage = outputData.getAdvanceMessage();
        if (outputData.isAdvanceSuccess()){
            commandPanelViewModel.appendOutput(advanceMessage);
        } else {
            commandPanelViewModel.appendError(advanceMessage);
        }
    }

}

package AdvanceUseCase;

import ViewModel.BoardPanelViewModel;
import ViewModel.PlayerPanelViewModel;
import ViewModel.PlayerViewModel;
import ViewModel.CommandPanelViewModel;

public class AdvancePresenter implements AdvanceOutputBoundary {

    CommandPanelViewModel commandPanelViewModel;

    BoardPanelViewModel boardPanelViewModel;

    PlayerPanelViewModel playerPanelViewModel;

    public AdvancePresenter(CommandPanelViewModel commandPanelViewModel, BoardPanelViewModel boardPanelViewModel,
                            PlayerPanelViewModel playerPanelViewModel){
        this.commandPanelViewModel = commandPanelViewModel;
        this.boardPanelViewModel = boardPanelViewModel;
        this.playerPanelViewModel = playerPanelViewModel;
    }

    /**
     * Updates viewmodel's command panel with results of the advance.
     * @param outputData message telling player which tile they have advanced to or an error
     *                   message if the tile wasn't found.
     */
    @Override
    public void performAction(AdvanceOutputData outputData){

        int playerIndex = outputData.getPlayerIndex();

        PlayerViewModel playerVM = playerPanelViewModel.getPlayerVMAt(playerIndex);

        String advanceMessage = outputData.getAdvanceMessage();
        if (outputData.isAdvanceSuccess()){
            commandPanelViewModel.appendOutput(advanceMessage);
            playerVM.setPosition(outputData.getPlayerLocation());

            playerPanelViewModel.notifyListeners();
            commandPanelViewModel.notifyListeners();
        } else {
            commandPanelViewModel.appendError(advanceMessage);

            commandPanelViewModel.notifyListeners();
        }
    }

}

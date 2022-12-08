package AdvanceUseCase;

import ViewModel.*;

public class AdvancePresenter implements AdvanceOutputBoundary {

    CommandPanelViewModel commandPanelViewModel;

    BoardPanelViewModel boardPanelViewModel;

    PlayerPanelViewModel playerPanelViewModel;

    InputMapDictionary inputMapDictionary;

    public AdvancePresenter(CommandPanelViewModel commandPanelViewModel, BoardPanelViewModel boardPanelViewModel,
                            PlayerPanelViewModel playerPanelViewModel, InputMapDictionary inputMapDictionary){
        this.commandPanelViewModel = commandPanelViewModel;
        this.boardPanelViewModel = boardPanelViewModel;
        this.playerPanelViewModel = playerPanelViewModel;
        this.inputMapDictionary = inputMapDictionary;
    }

    public AdvancePresenter(){

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
        } else {
            commandPanelViewModel.appendError(advanceMessage);
        }

        if (outputData.isUpdateInputMap()){
            inputMapDictionary.setCurrentMapName("after_move");

        }

        commandPanelViewModel.notifyListeners();
    }

    //Getters and Setters
    public void setCommandPanelViewModel(CommandPanelViewModel commandPanelViewModel) {
        this.commandPanelViewModel = commandPanelViewModel;
    }

    public void setBoardPanelViewModel(BoardPanelViewModel boardPanelViewModel) {
        this.boardPanelViewModel = boardPanelViewModel;
    }

    public void setInputMapDictionary(InputMapDictionary inputMapDictionary) {
        this.inputMapDictionary = inputMapDictionary;
    }

    public void setPlayerPanelViewModel(PlayerPanelViewModel playerPanelViewModel) {
        this.playerPanelViewModel = playerPanelViewModel;
    }

    public CommandPanelViewModel getCommandPanelViewModel() {
        return commandPanelViewModel;
    }

    public BoardPanelViewModel getBoardPanelViewModel() {
        return boardPanelViewModel;
    }

    public InputMapDictionary getInputMapDictionary() {
        return inputMapDictionary;
    }

    public PlayerPanelViewModel getPlayerPanelViewModel() {
        return playerPanelViewModel;
    }
}

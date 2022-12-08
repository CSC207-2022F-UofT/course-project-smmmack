package usecase_gotojail;

import viewmodel.CommandPanelViewModel;
import viewmodel.PlayerPanelViewModel;
import viewmodel.BoardPanelViewModel;
public class GoToJailPresenter implements GoToJailOutputBoundary{
    private PlayerPanelViewModel jailPlayerPanelViewModel;
    private CommandPanelViewModel commandPanelViewModel;
    private BoardPanelViewModel boardPanelViewModel;
    public GoToJailPresenter(PlayerPanelViewModel jailPlayerPanelViewModel, CommandPanelViewModel commandPanelViewModel,
                             BoardPanelViewModel boardPanelViewModel) {
        this.jailPlayerPanelViewModel = jailPlayerPanelViewModel;
        this.commandPanelViewModel = commandPanelViewModel;
        this.boardPanelViewModel = boardPanelViewModel;
    }

    public BoardPanelViewModel getBoardPanelViewModel() {
        return boardPanelViewModel;
    }

    public CommandPanelViewModel getCommandPanelViewModel() {
        return commandPanelViewModel;
    }

    public PlayerPanelViewModel getJailPlayerPanelViewModel() {
        return jailPlayerPanelViewModel;
    }

    public void setBoardPanelViewModel(BoardPanelViewModel boardPanelViewModel) {
        this.boardPanelViewModel = boardPanelViewModel;
    }

    public void setCommandPanelViewModel(CommandPanelViewModel commandPanelViewModel) {
        this.commandPanelViewModel = commandPanelViewModel;
    }

    public void setJailPlayerPanelViewModel(PlayerPanelViewModel jailPlayerPanelViewModel) {
        this.jailPlayerPanelViewModel = jailPlayerPanelViewModel;
    }

    public GoToJailPresenter(){

    }

    @Override
    public void performAction(GoToJailOutputData output) {
        jailPlayerPanelViewModel.getPlayerVMAt(output.getPlayerIndex()).setJailTurn(1);
        jailPlayerPanelViewModel.getPlayerVMAt(output.getPlayerIndex()).setPosition(output.getJailIndex());
        String Message = output.getMessage();
        commandPanelViewModel.appendOutput(Message);
        jailPlayerPanelViewModel.notifyListeners();
        boardPanelViewModel.notifyListeners();
    }
}



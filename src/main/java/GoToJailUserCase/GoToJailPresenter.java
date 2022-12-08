package GoToJailUserCase;

import ViewModel.CommandPanelViewModel;
import ViewModel.PlayerPanelViewModel;
import ViewModel.BoardPanelViewModel;
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



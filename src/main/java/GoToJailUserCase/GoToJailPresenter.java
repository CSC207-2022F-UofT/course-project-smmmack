package GoToJailUserCase;

import ViewModel.PlayerViewModel;
import ViewModel.CommandPanelViewModel;
public class GoToJailPresenter implements GoToJailOutputBoundary{
    PlayerViewModel jailPlayerViewModel;
    CommandPanelViewModel commandPanelViewModel;
    public GoToJailPresenter(PlayerViewModel jailPlayerViewModel, CommandPanelViewModel commandPanelViewModel) {
        this.jailPlayerViewModel = jailPlayerViewModel;
        this.commandPanelViewModel = commandPanelViewModel;
    }

    @Override
    public void create(GoToJailOutputData outputData) {
    }

    @Override
    public void performAction (GoToJailOutputData output) {
        jailPlayerViewModel.setJailTurn(1);
        String Message = output.getMessage();
        commandPanelViewModel.appendOutput(Message);
    }
}



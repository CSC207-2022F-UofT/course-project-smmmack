package GoToJailUserCase;

import ViewModel.PlayerViewModel;
public class GoToJailPresenter implements GoToJailOutputBoundary{
    PlayerViewModel jailPlayerViewModel;
    public GoToJailPresenter(PlayerViewModel jailPlayerViewModel) {
        this.jailPlayerViewModel = jailPlayerViewModel;
    }

    @Override
    public void create(GoToJailOutputData outputData) {
    }

    @Override
    public void performAction (GoToJailOutputData output) {
        jailPlayerViewModel.setJailTurn(1);
    }
}



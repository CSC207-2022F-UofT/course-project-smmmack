package DrawCardUseCase;
import ViewModel.*;

/**
 * This class updates the view models for the PlayerViewModel and CommandLineViewModel
 */

public class DrawCardPresenter implements DrawCardOutputBoundary{ 
    private CommandPanelViewModel commandPanelVM;
    private PlayerPanelViewModel playerPanelVM;

    public DrawCardPresenter(CommandPanelViewModel commandPanelVM, PlayerPanelViewModel playerPanelVM){
        this.commandPanelVM = commandPanelVM;
        this.playerPanelVM = playerPanelVM;
    }

    @Override
    public void performAction(DrawCardOutputData drawCardOutputData, String deckType) {
        String message = drawCardOutputData.getMessage();
        this.commandPanelVM.appendOutput(message);
        PlayerViewModel playerVM1 = playerPanelVM.getPlayerVMAt(drawCardOutputData.getPlayerIndex());
        if (drawCardOutputData.getIsGainCash()){
            playerVM1.setCash(playerVM1.getCash() + drawCardOutputData.getCashAmount());
        }
        else {
            playerVM1.setCash(playerVM1.getCash() - drawCardOutputData.getCashAmount());
        }
        playerPanelVM.notifyListeners();
    }

    //getter
    public CommandPanelViewModel getCommandPanelVM() {return commandPanelVM;}
    public PlayerPanelViewModel getPlayerPanelVM() {return playerPanelVM;}

    //setters
    public void setCommandPanelVM(CommandPanelViewModel commandPanelVM) {
        this.commandPanelVM = commandPanelVM;
    }
    public void setPlayerPanelVM(PlayerPanelViewModel playerPanelVM) {
        this.playerPanelVM = playerPanelVM;
    }
}


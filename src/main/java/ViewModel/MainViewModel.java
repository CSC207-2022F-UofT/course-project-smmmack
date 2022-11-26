package ViewModel;

/**
 * The MainViewModel is the view model that contains a reference to three view models: the board panel view model, the
 * player panel view model, and the command panel view model. While each view component should only have access to
 * their corresponding view models, the main view model should be accessible by all use cases. <br> <br>
 * This class is currently deprecated because each panel should only refer to their own view model but not the main view
 * model. This would avoid redundant updates.
 */
@Deprecated
public class MainViewModel {
    private BoardPanelViewModel boardPanelVM;
    private PlayerPanelViewModel playerPanelVM;
    private CommandPanelViewModel commandPanelVM;

    public MainViewModel(BoardPanelViewModel boardPanelVM,
                         PlayerPanelViewModel playerPanelVM,
                         CommandPanelViewModel commandPanelVM) {
        this.boardPanelVM = boardPanelVM;
        this.playerPanelVM = playerPanelVM;
        this.commandPanelVM = commandPanelVM;
    }

    //setters

    public void setBoardPanelVM(BoardPanelViewModel boardPanelVM) {
        this.boardPanelVM = boardPanelVM;
    }

    public void setPlayerPanelVM(PlayerPanelViewModel playerPanelVM) {
        this.playerPanelVM = playerPanelVM;
    }

    public void setCommandPanelVM(CommandPanelViewModel commandPanelVM) {
        this.commandPanelVM = commandPanelVM;
    }

    //getters

    public BoardPanelViewModel getBoardPanelVM() {
        return boardPanelVM;
    }

    public PlayerPanelViewModel getPlayerPanelVM() {
        return playerPanelVM;
    }

    public CommandPanelViewModel getCommandPanelVM() {
        return commandPanelVM;
    }
}

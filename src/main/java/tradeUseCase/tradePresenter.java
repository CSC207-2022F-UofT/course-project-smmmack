package tradeUseCase;
import ViewModel.CommandPanelViewModel;
import ViewModel.PlayerPanelViewModel;
import ViewModel.BoardPanelViewModel;
// import ViewModel.TradePanelViewModel;


public class tradePresenter implements tradeOutputBoundary {
    private CommandPanelViewModel commandPanelVM;
    private PlayerPanelViewModel playerPanelVM;
    private BoardPanelViewModel boardPanelVM;

    public tradePresenter(CommandPanelViewModel commandPanelVM, PlayerPanelViewModel playerPanelVM) {
        this.commandPanelVM = commandPanelVM;
        this.playerPanelVM = playerPanelVM;
    }
    @Override
    public void preformAction(tradeOutputData outputMessage) {
        String outputData = outputMessage.getTradeMessage();
        this.commandPanelVM.appendOutput(outputData);;
        commandPanelVM.notifyListeners();
        playerPanelVM.notifyListeners();
        boardPanelVM.notifyListeners();

    }
}

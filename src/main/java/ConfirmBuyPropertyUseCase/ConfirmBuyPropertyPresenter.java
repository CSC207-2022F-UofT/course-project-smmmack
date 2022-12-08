package ConfirmBuyPropertyUseCase;

import ViewModel.*;
import java.util.Collections;
import java.util.List;

public class ConfirmBuyPropertyPresenter implements ConfirmBuyPropertyOutputBoundary {

    private CommandPanelViewModel commandPanelViewModel;
    private PlayerPanelViewModel playerPanelViewModel;
    private BoardPanelViewModel boardPanelViewModel;
    private TileViewModel tileViewModel;
    private PlayerViewModel playerViewModel;

    public ConfirmBuyPropertyPresenter(CommandPanelViewModel commandPanelViewModel,
                                       PlayerPanelViewModel playerPanelViewModel,
                                       BoardPanelViewModel boardPanelViewModel,
                                       PlayerViewModel playerViewModel,
                                       TileViewModel tileViewModel) {
        this.commandPanelViewModel = commandPanelViewModel;
        this.playerPanelViewModel = playerPanelViewModel;
        this.boardPanelViewModel = boardPanelViewModel;
        this.playerViewModel = playerViewModel;
        this.tileViewModel = tileViewModel;
    }

    public ConfirmBuyPropertyPresenter(){

    }

    // Getters & Setters:

    public TileViewModel getTileViewModel() {
        return tileViewModel;
    }

    public PlayerViewModel getPlayerViewModel() {
        return playerViewModel;
    }

    public CommandPanelViewModel getCommandPanelViewModel() {
        return commandPanelViewModel;
    }

    public void setCommandPanelViewModel(CommandPanelViewModel commandPanelViewModel) {
        this.commandPanelViewModel = commandPanelViewModel;
    }

    public PlayerPanelViewModel getPlayerPanelViewModel() {
        return playerPanelViewModel;
    }

    public void setPlayerPanelViewModel(PlayerPanelViewModel playerPanelViewModel) {
        this.playerPanelViewModel = playerPanelViewModel;
    }

    public BoardPanelViewModel getBoardPanelViewModel() {
        return boardPanelViewModel;
    }

    public void setBoardPanelViewModel(BoardPanelViewModel boardPanelViewModel) {
        this.boardPanelViewModel = boardPanelViewModel;
    }

    public void setTileViewModel(TileViewModel tileViewModel) {
        this.tileViewModel = tileViewModel;
    }

    public void setPlayerViewModel(PlayerViewModel playerViewModel) {
        this.playerViewModel = playerViewModel;
    }

    /**
     * Update the ViewModel's commend panel about the successful or unsuccessful
     * result of purchasing the landed on property.
     * @param buyPropertyOutputData The message informing whether the player purchased the
     *                              property or not: successfully purchased; unsuccessful
     *                              attempt of purchase, not enough funds; unsuccessful
     *                              attempt of purchase, the property is already owned. Further,
     *                              the message displays error if the purchase cannot proceed.
     */

    @Override
    public void performAction(ConfirmBuyPropertyOutputData buyPropertyOutputData){
        String message = buyPropertyOutputData.getMessage();
        commandPanelViewModel.appendCommandLine(message, buyPropertyOutputData.getConfirmPurchase());
        PlayerViewModel playerVM = playerPanelViewModel.getPlayerVMAt(buyPropertyOutputData.getPlayerIndex());
        TileViewModel tileVM = boardPanelViewModel.getTileVMAt(playerVM.getPosition());
        List<String> propertyVM = Collections.singletonList(buyPropertyOutputData.getPropertyAbbreviation());
        int playerCashAfterPurchase = buyPropertyOutputData.getPlayerCashAfterPurchase();
        playerPanelViewModel.getPlayerVMAt(buyPropertyOutputData.getPlayerIndex()).setCash(playerCashAfterPurchase);
        playerVM.addPropertyAbbrs(propertyVM);
        tileVM.setOwnershipIndex(buyPropertyOutputData.playerIndex);
        playerVM.addPropertyAbbrs(propertyVM);
        playerPanelViewModel.notifyListeners();
    }
}

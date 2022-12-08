package ConfirmBuyPropertyUseCase;

import ViewModel.*;
import java.util.Collections;
import java.util.List;

public class ConfirmBuyPropertyPresenter implements ConfirmBuyPropertyOutputBoundary {

    private CommandPanelViewModel commandPanelViewModel;
    private PlayerPanelViewModel playerPanelViewModel;
    private BoardPanelViewModel boardPanelViewModel;
    private InputMapDictionary mapDictionary;

    public ConfirmBuyPropertyPresenter(CommandPanelViewModel commandPanelViewModel,
                                       PlayerPanelViewModel playerPanelViewModel,
                                       BoardPanelViewModel boardPanelViewModel) {
        this.commandPanelViewModel = commandPanelViewModel;
        this.playerPanelViewModel = playerPanelViewModel;
        this.boardPanelViewModel = boardPanelViewModel;
    }

    public ConfirmBuyPropertyPresenter(){

    }

    // Getters & Setters:

    public CommandPanelViewModel getCommandPanelViewModel() {
        return commandPanelViewModel;
    }

    public void setCommandPanelViewModel(CommandPanelViewModel commandPanelViewModel) {
        this.commandPanelViewModel = commandPanelViewModel;
    }

    public PlayerPanelViewModel getPlayerPanelViewModel() {
        return playerPanelViewModel;
    }

    public InputMapDictionary getMapDictionary() {
        return mapDictionary;
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

    public void setMapDictionary(InputMapDictionary mapDictionary) {
        this.mapDictionary = mapDictionary;
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
        boardPanelViewModel.notifyListeners();
        commandPanelViewModel.notifyListeners();
        mapDictionary.setCurrentMapName("after_move");

    }
}

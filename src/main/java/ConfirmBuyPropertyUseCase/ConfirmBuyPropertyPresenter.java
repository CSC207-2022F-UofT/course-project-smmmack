package ConfirmBuyPropertyUseCase;

import ViewModel.*;

public class ConfirmBuyPropertyPresenter implements ConfirmBuyPropertyOutputBoundary {

    private final CommandPanelViewModel commandPanelViewModel;
    private final PlayerPanelViewModel playerPanelViewModel;
    private final BoardPanelViewModel boardPanelViewModel;
    private final PlayerViewModel playerViewModel;
    private final TileViewModel tileViewModel;

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
        tileVM.setOwnershipIndex(buyPropertyOutputData.playerIndex);
        playerVM.
        playerPanelViewModel.notifyListeners();

    }
}

package ConfirmBuyPropertyUseCase;

import ViewModel.CommandPanelViewModel;

public class ConfirmBuyPropertyPresenter implements ConfirmBuyPropertyOutputBoundary {

    CommandPanelViewModel commandPanelViewModel;

    public ConfirmBuyPropertyPresenter(CommandPanelViewModel commandPanelViewModel) {
        this.commandPanelViewModel = commandPanelViewModel;
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

        if(buyPropertyOutputData.confirmPurchase){
            commandPanelViewModel.appendOutput(message);
        } else {
            commandPanelViewModel.appendOutput(message);
        }
    }
}

package RollDiceUseCase;

import AdvanceUseCase.AdvanceOutputBoundary;
import ViewModel.CommandLineViewModel;
import ViewModel.CommandPanelViewModel;

public class RollDicePresenter implements RollDiceOutputBoundary{

    CommandPanelViewModel commandPanelViewModel;

    public RollDicePresenter(CommandPanelViewModel commandPanelViewModel){
        this.commandPanelViewModel = commandPanelViewModel;
    }

    /**
     * Displays the results of the dice roll.
     * @param diceOutputData output data from the interactor.
     */
    @Override
    public void performAction(RollDiceOutputData diceOutputData){

        String diceRollMessage = diceOutputData.getRollDiceMessage();

        if (diceOutputData.isValidInput()){
            commandPanelViewModel.appendOutput(diceRollMessage);
        }
        else{
            commandPanelViewModel.appendWarning(diceRollMessage);
        }

        //keep reference of input map dictionary, board panel vm update

    }
}

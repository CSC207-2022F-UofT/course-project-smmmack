package RollDiceUseCase;

import AdvanceUseCase.AdvanceOutputBoundary;
import ViewModel.*;

public class RollDicePresenter implements RollDiceOutputBoundary{

    CommandPanelViewModel commandPanelViewModel;
    BoardPanelViewModel boardPanelViewModel;

    public RollDicePresenter(CommandPanelViewModel commandPanelViewModel, BoardPanelViewModel boardPanelViewModel,
                             InputMapDictionary inputMapDict){
        this.commandPanelViewModel = commandPanelViewModel;
        this.boardPanelViewModel = boardPanelViewModel;

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

        //boardPanelViewModel.

        //keep reference of input map dictionary, board panel vm update

    }
}

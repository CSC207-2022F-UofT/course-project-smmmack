package RollDiceUseCase;
import ViewModel.*;

public class RollDicePresenter implements RollDiceOutputBoundary{

    CommandPanelViewModel commandPanelViewModel;
    BoardPanelViewModel boardPanelViewModel;

    public RollDicePresenter(CommandPanelViewModel commandPanelViewModel, BoardPanelViewModel boardPanelViewModel,
                             InputMapDictionary inputMapDict){
        this.commandPanelViewModel = commandPanelViewModel;
        this.boardPanelViewModel = boardPanelViewModel;

    }

    public RollDicePresenter(){}


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

    }

    public BoardPanelViewModel getBoardPanelViewModel() {
        return boardPanelViewModel;
    }

    public CommandPanelViewModel getCommandPanelViewModel() {
        return commandPanelViewModel;
    }

    public void setBoardPanelViewModel(BoardPanelViewModel boardPanelViewModel) {
        this.boardPanelViewModel = boardPanelViewModel;
    }

    public void setCommandPanelViewModel(CommandPanelViewModel commandPanelViewModel) {
        this.commandPanelViewModel = commandPanelViewModel;
    }
}

package usecase_initiatebuyproperty;

import viewmodel.CommandPanelViewModel;
import viewmodel.InputMapDictionary;


public class InitiateBuyPropertyPresenter implements InitiateBuyPropertyOutputBoundary{

    CommandPanelViewModel commandPanelViewModel;
    InputMapDictionary inputMapDictionary;

    public InitiateBuyPropertyPresenter(CommandPanelViewModel commandPanelViewModel,
                                        InputMapDictionary inputMapDictionary) {
        this.commandPanelViewModel = commandPanelViewModel;
        this.inputMapDictionary = inputMapDictionary;
    }

    public InitiateBuyPropertyPresenter(){

    }

    // Getters & Setters:
    public CommandPanelViewModel getCommandPanelViewModel() {
        return commandPanelViewModel;
    }

    public void setCommandPanelViewModel(CommandPanelViewModel commandPanelViewModel) {
        this.commandPanelViewModel = commandPanelViewModel;
    }

    public InputMapDictionary getInputMapDictionary() {
        return inputMapDictionary;
    }

    public void setInputMapDictionary(InputMapDictionary inputMapDictionary) {
        this.inputMapDictionary = inputMapDictionary;
    }

    /**
     * Update the ViewModel's panel with the question asking the player whether the player
     * wants to purchase the property or not; the decision of the player can be yes if the player
     * attempts to purchase the landed on property, no otherwise.
     *
     * @param initiateBuyPropertyOutputData The question asking the player if the player wants
     *                                      to attempt to purchase the landed on property, informing
     *                                      the price & the name of the property to the player; the
     *                                      response can either be yes if the player attempts to purchase
     *                                      the property, no otherwise. Does not appear a question
     *                                      if the player does not land on a property tile.
     */

    @Override
    public void performAction(InitiateBuyPropertyOutputData initiateBuyPropertyOutputData){
        String question = initiateBuyPropertyOutputData.getQuestion();

        inputMapDictionary.setCurrentMapName("confirm_buy_land");

        if(initiateBuyPropertyOutputData.checkPropertyTileQuestion){
            commandPanelViewModel.appendOutput(question);

        } else {
            commandPanelViewModel.appendError(question);
        }
    }
}

package DrawCard;

import MainEntities.Deck;

public class DrawCardController {
    //Add more variables and create methods, calls interactor
    private DrawCardInputBoundary input;
    final String playerName;
    final Deck deckType;

    public DrawCardController(DrawCardInputBoundary input, String playerName, Deck deckType) {
        this.input = input;
        this.playerName = playerName;
        this.deckType = deckType;
    }

    void performAction() throws Exception {
        DrawCardInputData drawCardInputData = new DrawCardInputData(playerName, deckType);
        input.performAction(drawCardInputData);
    }

    // getters
    public DrawCardInputBoundary getInputDrawCard(){
        return input;
    }

    public String getPlayerName(){
        return playerName;
    }

    public Deck getDeckType(){
        return deckType;
    }

    // setters
    public void setInputDrawCard(DrawCardInputBoundary input){
        this.input = input;
    }
}

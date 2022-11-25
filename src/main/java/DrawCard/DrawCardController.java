package DrawCard;

import MainEntities.Deck;

public class DrawCardController {
    //Add more variables and create methods
    final DrawCardInputBoundary input;
    final String playerName;
    final Deck deckType;

    public DrawCardController(DrawCardInputBoundary input, String playerName, Deck deckType) {
        this.input = input;
        this.playerName = playerName;
        this.deckType = deckType;
    }

    DrawCardOutputData create() throws Exception {
        DrawCardInputData drawCardInputData = new DrawCardInputData(playerName, deckType);
        return input.create(drawCardInputData);
    }
}

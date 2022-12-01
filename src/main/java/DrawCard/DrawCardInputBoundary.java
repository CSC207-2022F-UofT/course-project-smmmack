package DrawCard;

import MainEntities.Deck;

public interface DrawCardInputBoundary {
    DrawCardOutputData performAction(DrawCardInputData drawCardInputData) throws Exception;

    void performAction(DrawCardInputData drawCardInput, Deck deckType) throws Exception;
}


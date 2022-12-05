package DrawCard;

import MainEntities.Deck;

public interface DrawCardInputBoundary {
    void performAction(DrawCardInputData drawCardInput, Deck deckType) throws Exception;

    void performAction(DrawCardInputData drawCardInput) throws Exception;
}


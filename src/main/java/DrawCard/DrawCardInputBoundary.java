package DrawCard;

import MainEntities.Deck;

public interface DrawCardInputBoundary {
    void performAction(DrawCardInputData drawCardInput, String deckType) throws Exception;
}
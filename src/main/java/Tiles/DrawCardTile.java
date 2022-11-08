package Tiles;

import MainEntities.Deck;

/**
 * DrawCardTile let anyone who steps on it draw a card from the corresponding deck, and perform the
 * corresponding actions.
 */
public class DrawCardTile extends Tile{
    private Deck deck;

    public DrawCardTile(Deck deck) {
        this.deck = deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Deck getDeck() {
        return deck;
    }
}

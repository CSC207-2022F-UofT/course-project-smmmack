package entities_tiles;

import entities_main.Deck;

import java.io.Serializable;

/**
 * DrawCardTile let anyone who steps on it draw a card from the corresponding deck, and perform the
 * corresponding actions.
 */
public class DrawCardTile extends Tile implements Serializable {
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

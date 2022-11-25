package MainEntities;

import Cards.Card;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Deck is a collection of cards. When a card is drawn, it's drawn from the top of the deck. When a card is put in the
 * deck, it's put at the bottom of the deck.
 */
public class Deck implements Serializable {
    /**
     * In an ordinary game, the type of the card should be either "community chest" or "chance"
     */
    private String type;
    private Queue<Card> cards;

    /**
     * Create a new Card instance
     * @param type The type of the card in the deck. Typically, "community chest" or "chance".
     * @param cards A list of cards to be added in the deck.
     */
    public Deck(String type, List<Card> cards) {
        this.type = type;
        this.cards = new ArrayDeque<>(cards);
    }

    /**
     * Create a new Card instance. The cards in the deck is initiated as an empty queue.
     * @param type The type of the card in the deck. Typically, "community chest" or "chance".
     */
    public Deck(String type) {
        this.type = type;
        this.cards = new ArrayDeque<>();
    }

    //setters

    public void setType(String type) {
        this.type = type;
    }

    public void setCards(List<Card> cards) {
        this.cards = new ArrayDeque<>(cards);
    }

    //getters

    public String getType() {
        return type;
    }

    /**
     * @return a copy of the queue of all the cards in the deck.
     */
    public ArrayDeque<Card> getCards() {
        return new ArrayDeque<>(cards);
    }

    //other getters

    /**
     * Draws a card from the top of the deck. The card is then REMOVED from the deck, and should be added back again
     * using putCard() if it needs to be put back.
     * @return the card on the top of the deck.
     */
    public Card drawCard() {
        try {
            return cards.remove();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Drawing card from an empty deck is impossible.");
        }
    }

    /**
     * @return The number of cards in the deck.
     */
    public int getSize() {
        return cards.size();
    }

    //other setters

    /**
     * Put a card at the bottom of deck.
     * @param card The card to be put at the bottom of the deck.
     */
    public void putCard(Card card) {
        cards.add(card);
    }
}

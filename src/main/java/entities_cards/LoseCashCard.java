package entities_cards;

import java.io.Serializable;

/**
 * LoseCashCard is a type of Card. When a player draws it, he loses a specific amount of cash.
 */
public class LoseCashCard extends Card implements Serializable {
    /**
     * The amount of cash to be lost. It should be a positive value.
     */
    private int amount;

    /**
     * Creates a new Card instance
     * @param name The name of the card.
     * @param description The description of the card.
     * @param type The type of the card. Typically, "community chest" or "chance"
     * @param amount The amount of cash to be lost. It should be a positive value.
     */
    public LoseCashCard(String name, String description, String type, int amount) {
        super(name, description, type);
        this.amount = amount;
    }

    //setters

    public void setAmount(int amount) {
        this.amount = amount;
    }

    //getters

    public int getAmount() {
        return amount;
    }
}

package Cards;

/**
 * An abstract class for all cards.
 */
public abstract class Card {
    private String name;
    private String description;
    /**
     * In an ordinary game, the type of the card should be either "community chest" or "chance"
     */
    private String type;

    /**
     * Creates a new Card instance
     * @param name The name of the card.
     * @param description The description of the card.
     * @param type The type of the card. Typically, "community chest" or "chance"
     */
    public Card(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    //getters

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}

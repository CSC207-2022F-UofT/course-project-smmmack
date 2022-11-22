package MainEntities;

import Properties.NormalProperty;
import Properties.Property;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * Player contains every information about a player, including the name, cash, location, and owned properties.
 */
public class Player implements Serializable {
    public static final Player OWNERLESS = null;
    public static final Player BANK = null;

    private String name;
    private int cash;
    private int location;
    private List<Property> properties;
    /**
     * The number of turns the player need to stay in jail. Int implementation allows sentences longer than 1 turn.
     */
    private int jailTurn;
    /**
     * Create a new Player object with these default parameters: <br>
     * cash = 0 <br>
     * location = 0 <br>
     * properties = new ArrayList<br>
     * jailTurn = 0
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.cash = 0;
        this.location = 0;
        this.properties = new ArrayList<>();
        this.jailTurn = 0;
    }

    //getters

    public String getName() {
        return name;
    }

    public int getCash() {
        return cash;
    }

    public int getLocation() {
        return location;
    }

    public ArrayList<Property> getProperties() {
        return new ArrayList<>(properties);
    }

    public int getJailTurn() {
        return jailTurn;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void setProperties(List<Property> properties) {
        this.properties = new ArrayList<>(properties);
    }

    public void setJailTurn(int jailTurn) {
        this.jailTurn = jailTurn;
    }

    //other getters

    public boolean ownsProperty(Property property) {
        return properties.contains(property);
    }

    /**
     * @param property The property that we need to know if the player owns all properties in the same group of it or
     *                 not. If the player does not own this property, then return false.
     * @return A boolean variable indicating whether the player owns all properties in the same color group or not.
     */
    public boolean ownsColorGroupOf(NormalProperty property) {
        if (ownsProperty(property)) {
            for (NormalProperty other: property.getSameColorGroupProperties()) {
                if (! ownsProperty(other)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    //other setters

    public void gainCash(int amount) {
        cash += amount;
    }

    public void loseCash(int amount) {
        cash -= amount;
    }

    /**
     * Add a property to the list of owned properties of the player. <br>
     * CAUTION: this does NOT keep the consistency between the owner and the owned properties.
     * @param property the property to be added to the list
     */
    public void addProperty(Property property) {
        this.properties.add(property);
    }

    /**
     * Remove a property from the list of owned properties of the player. <br>
     * CAUTION: this does NOT keep the consistency between the owner and the owned properties.
     * @param property the property to be removed from the list
     */
    public void removeProperty(Property property) {
        this.properties.remove(property);
    }

    /**
     * Adds this property to the owner's list of owned properties and set the ownership of the property to this player.
     * If the property already has a owner, remove the ownership. This keeps the consistency between the owner and
     * owned properties.
     * @param property the property to be assigned
     */
    public void assignOwnership(Property property) {
        if (property.getOwner() != Player.OWNERLESS) {
            property.removeOwnership();
        }
        property.setOwner(this);
        this.addProperty(property);
    }
}

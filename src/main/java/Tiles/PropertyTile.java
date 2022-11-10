package Tiles;

import Properties.Property;

/**
 * PropertyTile is a tile that corresponds to a property. If any player stepped on an owner-less property, then he or
 * she may buy the property. If the property is already owned by others, he or she has to pay tax to the owner.
 */
public class PropertyTile extends Tile {
    private Property property;

    /**
     * @param property The corresponding property of the property tile.
     */
    public PropertyTile(Property property) {
        this.property = property;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}

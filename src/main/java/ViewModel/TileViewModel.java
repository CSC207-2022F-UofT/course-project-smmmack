package ViewModel;

/**
 * TileViewModel contains all information that the view need for a tile
 */
public class TileViewModel {
    public static final int NO_OWNERSHIP_INDEX = -1;
    private int houseLevel;
    private int ownershipIndex;
    private boolean mortgaged;

    //getters

    public int getHouseLevel() {
        return houseLevel;
    }

    public int getOwnershipIndex() {
        return ownershipIndex;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }

    //setters

    public void setHouseLevel(int houseLevel) {
        this.houseLevel = houseLevel;
    }

    public void setOwnershipIndex(int ownershipIndex) {
        this.ownershipIndex = ownershipIndex;
    }

    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }

    //other setters

    public void removeOwnership() {
        this.ownershipIndex = NO_OWNERSHIP_INDEX;
    }
}

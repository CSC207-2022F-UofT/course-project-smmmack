package usecase_initiatebuyproperty;

public class InitiateBuyPropertyInputData {

    boolean landedOnPropertyTile;

    /**
     *
     * @param landedOnPropertyTile Demonstrates whether the player is landed on a property
     *                             tile or not.
     */

    public InitiateBuyPropertyInputData(boolean landedOnPropertyTile){
        this.landedOnPropertyTile = landedOnPropertyTile;
    }

    // Getter:

    public boolean getLandedOnPropertyTile() {
        return landedOnPropertyTile;
    }

    // Setter:

    public void setLandedOnPropertyTile(boolean landedOnPropertyTile) {
        this.landedOnPropertyTile = landedOnPropertyTile;
    }
}

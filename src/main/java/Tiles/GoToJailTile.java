package Tiles;

import java.io.Serializable;

/**
 * GoToJailTile sends whoever steps on it to jail, and stay there for one turn.
 */
public class GoToJailTile extends Tile implements Serializable {
    /**
     * The corresponding JailTile of this GoToJailTile.
     */
    private JailTile jailTile;

    public GoToJailTile(JailTile jailTile) {
        this.jailTile = jailTile;
    }

    public JailTile getJailTile() {
        return jailTile;
    }

    public void setJailTile(JailTile jailTile) {
        this.jailTile = jailTile;
    }
}

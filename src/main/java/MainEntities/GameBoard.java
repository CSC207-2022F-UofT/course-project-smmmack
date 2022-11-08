package MainEntities;

import Tiles.Tile;

import java.security.InvalidParameterException;

/**
 * GameBoard is a class that contains the width, length, and the array of tiles in a board. <p>
 * The width and height of the board are final.
 */
public class GameBoard {
    private final int width;
    private final int height;
    private Tile[] tiles;

    /**
     * Return a GameBoard instance
     * @param width The width of the board, measured in tiles. No less than 2.
     * @param height The height of the board, measured in tiles. No less than 2.
     */
    public GameBoard(int width, int height) throws InvalidParameterException {
        if (width < 2 || height < 2) {
            throw new InvalidParameterException("Width and height of a game board can't be less than or equal to 2.");
        }
        this.width = width;
        this.height = height;
        this.tiles = new Tile[getSize()];
    }

    //setters

    /**
     * @param tiles An array of tiles that is to be cloned into the tiles array of this GameBoard. The size of the new
     *              tiles array must be the same as the size of the board, else an InvalidParametersException would be
     *              thrown.
     */
    public void setTiles(Tile[] tiles) throws InvalidParameterException {
        if (tiles.length != getSize()) {
            throw new InvalidParameterException("The size of the board is immutable.");
        } else {
            this.tiles = tiles.clone();
        }
    }

    /**
     * @param index The index of the tile that is to be changed
     * @param tile The tile that is to be changed to
     */
    public void setTileAt(int index, Tile tile) {
        tiles[index] = tile;
    }

    //getters
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSize() {
        return width * 2 + height * 2 - 4;
    }

    public Tile[] getTiles() {
        return tiles.clone();
    }

    public Tile getTileAt(int index) {
        return tiles[index];
    }
}

package MainEntities;

import Tiles.Tile;

import java.security.InvalidParameterException;

/**
 * GameBoard is a class that contains the width, length, and the array of tiles in a board. <br>
 * The width and height of the board are final, and can't be less than 2.
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
            throw new InvalidParameterException("The size of input Array does not match the size of the board.");
        } else {
            this.tiles = tiles.clone();
        }
    }

    /**
     * Set a single tile on the board at a specific index to the given Tile.
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

    //Other getters

    /**
     * @return The size of the board - how many tiles does it contain.
     */
    public int getSize() {
        return width * 2 + height * 2 - 4;
    }


    public Tile[] getTiles() {
        return tiles;
    }

    /**
     * Get the tiles at a specific index.
     * @param index the index of the tile wanted.
     * @return The tile at that index.
     */
    public Tile getTileAt(int index) {
        try {
            return tiles[index];
        } catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Tile index out of bounds");
        }
    }
}

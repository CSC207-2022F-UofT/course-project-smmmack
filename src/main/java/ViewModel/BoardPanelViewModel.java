package ViewModel;

import Tiles.Tile;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * BoardPanelViewModel is a view model that contains an array of TileViewModels. It also contains all information
 * needed by the board panel in the view. <br>
 * As the BoardPanel is a picture, it might also need methods to get the coordinates of different tiles, so that the
 * program can put the chess, ownership indicator, and houses at the correct place. <br>
 * Just the same as GameBoard, BoardPanelViewModel has final width and height, and both are no less than 2.
 */
public class BoardPanelViewModel {
    private final int width;
    private final int height;
    private TileViewModel[] tileVMs;
    private List<BoardPanelVMListener> listeners;

    public BoardPanelViewModel(int width, int height) throws InvalidParameterException {
        if (width < 2 || height < 2) {
            throw new InvalidParameterException("Width and height of a game board can't be less than or equal to 2.");
        }
        this.width = width;
        this.height = height;
        this.tileVMs = new TileViewModel[getSize()];
        this.listeners = new ArrayList<>();
    }

    //setters

    /**
     * @param tileVMs An array of tileVMs that is to be cloned into the tileVMs array of this BoardPanelVM. The size of
     *                the new tileVMs array must be the same as the size of the board panel VM, else an
     *                InvalidParametersException would be thrown.
     */
    public void setTileVMs(TileViewModel[] tileVMs) throws InvalidParameterException {
        if (tileVMs.length != getSize()) {
            throw new InvalidParameterException("The size of input Array does not match the size of the board.");
        } else {
            this.tileVMs = tileVMs.clone();
        }
    }

    /**
     * Set a single tile VM on the board panel VM at a specific index to the given TileVM.
     * @param index The index of the tileVM that is to be changed
     * @param tileVM The tile that is to be changed to
     */
    public void setTileVMAt(int index, TileViewModel tileVM) {
        tileVMs[index] = tileVM;
    }

    //getters

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public TileViewModel[] getTileVMs() {
        return tileVMs.clone();
    }

    public TileViewModel getTileVMAt(int index) {
        try {
            return tileVMs[index];
        } catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("TileVM index out of bounds");
        }
    }

    //other getters

    public int getSize() {
        return width * 2 + height * 2 - 4;
    }

    //other setters
    public void addListener(BoardPanelVMListener listener) {
        this.listeners.add(listener);
    }

    public boolean removeListener(BoardPanelVMListener listener) {
        return this.listeners.remove(listener);
    }

    //other methods

    public void notifyListeners() {
        for (BoardPanelVMListener listener: listeners) {
            listener.performAction();
        }
    }

}

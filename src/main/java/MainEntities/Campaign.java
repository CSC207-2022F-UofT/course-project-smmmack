package MainEntities;

import Cards.Card;
import Tiles.Tile;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Campaign class includes all information about a game: its players, board, round count, and the current player. All
 * use case interactors should have a reference of the corresponding campaign.
 */
public class Campaign {
    private GameBoard board;
    private List<Player> players;
    /**
     * Maps the decks to their corresponding types.
     */
    private Map<String, Deck> decks;
    private int roundCount;
    /**
     * The index of the player currently in turn. This index must be in the list of players.
     */
    private int currPlayerIndex;

    /**
     * Create a new Campaign instance with these default parameters: <br>
     * roundCount = 0 <br>
     * currPlayerIndex = 0
     *
     * @param board The board of the game
     *
     * @param players The list of players of the game. The first player to move should be the first element of the
     *                list.
     *
     * @param decks The list of decks of the game.
     */
    public Campaign (GameBoard board, List<Player> players, List<Deck> decks) {
        this.board = board;
        this.players = players;
        this.decks = new HashMap<>();
        for (Deck deck: decks) {
            this.decks.put(deck.getType(), deck);
        }
        this.roundCount = 0;
        this.currPlayerIndex = 0;
    }

    //setters

    public void setBoard(GameBoard board) {
        this.board = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = new HashMap<>();
        for (Deck deck: decks) {
            this.decks.put(deck.getType(), deck);
        }
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public void setCurrPlayerIndex(int currPlayerIndex) {
        this.currPlayerIndex = currPlayerIndex;
    }

    //getters

    public GameBoard getBoard() {
        return board;
    }

    public Map<String, Deck> getDecks() {
        return decks;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getCurrPlayerIndex() {
        return currPlayerIndex;
    }

    public int getRoundCount() {
        return roundCount;
    }

    //other getters

    public Player getPlayerAt(int index) {
        return players.get(index);
    }

    public Player getPlayerCalled(String name) throws InvalidParameterException {
        for (Player p: players) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        throw new InvalidParameterException("No player with name: " + name);
    }

    public Player getCurrentPlayer() {
        return players.get(currPlayerIndex);
    }

    public Tile getTileAt(int index) {
        return board.getTileAt(index);
    }

    public int getBoardWidth() {
        return board.getWidth();
    }

    public int getBoardHeight() {
        return board.getHeight();
    }

    public int getBoardSize() {
        return board.getSize();
    }

    public int getPlayerNumber() {
        return players.size();
    }

    public Deck getDeck(String type) {
        return decks.get(type);
    }

    public Card drawCardFromDeck(String type) {
        return getDeck(type).drawCard();
    }

    //other setters

    public void incrementRoundCount() {
        roundCount += 1;
    }

    public void incrementCurrPlayerIndex() {
        currPlayerIndex = (currPlayerIndex + 1) / getPlayerNumber();
    }

    public void putCardInDeck(String type, Card card) {
        getDeck(type).putCard(card);
    }
}

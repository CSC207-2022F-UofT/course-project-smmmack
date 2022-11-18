package MainEntities;

import Cards.Card;
import Tiles.Tile;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Campaign class includes all information about a game: its players, board, round count, and the current player. All
 * use case interactors should have a reference of the corresponding campaign.
 */
public class Campaign {
    private GameBoard board;

    /**
     * The list of players in the campaign. Arranged in the order of round succession.
     */
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

    public ArrayList<Player> getPlayers() {
        return new ArrayList<>(players);
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

    /**
     * Get a player by the name of the player. Notice: if there are players of duplicate names in the players
     * @param name name of the player wanted
     * @return the player of the name
     * @throws InvalidParameterException when no such player is found.
     */
    public Player getPlayerCalled(String name) throws InvalidParameterException {
        for (Player p: players) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        throw new InvalidParameterException("No player with name: " + name);
    }

    /**
     * @return the current player that is taking turn in the campaign.
     */
    public Player getCurrentPlayer() {
        return players.get(currPlayerIndex);
    }

    /**
     * Get a tile at a specific index on the board.
     * @param index The index of the wanted tile.
     * @return The tile at the said index.
     */
    public Tile getTileAt(int index) {
        return board.getTileAt(index);
    }

    /**
     * Get a tile under a specific player.
     * @param player The player standing on the wanted tile.
     * @return The tile under the said player.
     */
    public Tile getTileUnderPlayer(Player player) {
        return getTileAt(player.getLocation());
    }

    /**
     * @return the width of the board in the campaign.
     */
    public int getBoardWidth() {
        return board.getWidth();
    }

    /**
     * @return the height of the board in the campaign.
     */
    public int getBoardHeight() {
        return board.getHeight();
    }

    /**
     * @return the size of the board in the campaign.
     */
    public int getBoardSize() {
        return board.getSize();
    }

    /**
     * @return the number of players in the campaign.
     */
    public int getPlayerNumber() {
        return players.size();
    }

    /**
     * Get deck of a specific type in the Campaign. If there is no deck of such type, throws an exception.
     * @param type the type of the deck wanted (typically community chest or chance)
     * @return the corresponding deck in the campaign
     * @throws InvalidParameterException if there is no deck of such type requested
     */
    public Deck getDeck(String type) throws InvalidParameterException {
        Deck result = decks.get(type);
        if (result == null) {
            throw new InvalidParameterException("Deck of type " + type + " does not exist in the campaign");
        } else {
            return result;
        }
    }

    public Card drawCardFromDeck(String type) {
        return getDeck(type).drawCard();
    }

    //other setters

    /**
     * Increments the roundCount (round count) by 1.
     */
    public void incrementRoundCount() {
        roundCount += 1;
    }

    /**
     * Increments the currPlayerIndex (the index of the current player in the player list) by 1. If it reaches the end
     * of the list, the index returns to 0.
     */
    public void incrementCurrPlayerIndex() {
        currPlayerIndex = (currPlayerIndex + 1) / getPlayerNumber();
    }

    /**
     * Put a card at the bottom of the deck of a specific type.
     * @param type the type of the deck.
     * @param card the card to be put at the bottom of the deck.
     */
    public void putCardInDeck(String type, Card card) {
        getDeck(type).putCard(card);
    }
}

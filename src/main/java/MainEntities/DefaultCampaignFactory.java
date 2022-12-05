package MainEntities;

import Cards.*;
import Properties.NormalProperty;
import Tiles.*;

import java.util.ArrayList;

public class DefaultCampaignFactory implements CampaignFactory {
    private int playerNumber;
    public static final int MIN_PLAYER_NUM = 2;
    public static final int MAX_PLAYER_NUM = 8;

    /**
     * Construct a DefaultCampaignFactory instance with designated player number. The player number should be in range
     * [MIN_PLAYER_NUM, MAX_PLAYER_NUM]
     * @param playerNumber the number of players in the campaign.
     */
    public DefaultCampaignFactory(int playerNumber) {
        setPlayerNumber(playerNumber);
    }

    //getters

    public int getPlayerNumber() {
        return playerNumber;
    }

    //setters

    /**
     * Set the number of players in the campaign, the player number has to be in range [MIN_PLAYER_NUM, MAX_PLAYER_NUM]
     * @param playerNumber the number of players
     */
    public void setPlayerNumber(int playerNumber) {
        if (playerNumber < MIN_PLAYER_NUM || playerNumber > MAX_PLAYER_NUM) {
            throw new IllegalArgumentException("player number in DefaultCampaignFactory must be in range " +
                    "[" + MIN_PLAYER_NUM + ", " + MAX_PLAYER_NUM + "]");
        }
        this.playerNumber = playerNumber;
    }

    /**
     * Create a campaign all at starting location with a specific number of players. The players are named p1, p2,
     * p3 ... and so on. <br>
     * Each player initially owns 1000 dollars.
     * @return an initialised campaign object
     */
    @Override
    public Campaign create() {
        // Initialize the list of players
        ArrayList<Player> playerList= new ArrayList<>();
        for (int i = 1; i <= playerNumber; i ++) {
            String playerName = "p" + i;
            Player player = new Player(playerName);
            player.setCash(1000);
            playerList.add(player);
        }

        // Initialize community chest deck
        Deck cChestDeck = createCChestDeck();

        // Initialize chance deck
        Deck chanceDeck = createChanceDeck();

        // Create map of decks
        ArrayList<Deck> decks = new ArrayList<>();
        decks.add(cChestDeck);
        decks.add(chanceDeck);

        // Initialize board
        GameBoard board = new GameBoard(9, 9);
        board.setTiles(createTileArray(cChestDeck, chanceDeck));

        // Call Campaign Constructor
        return new Campaign(board, playerList, decks);
    }

    public Deck createCChestDeck() {
        Card card1 = new GainCashCard(
                "Tuition Error",
                "Tuition error in your favor, gain 200 Tbucks",
                "community chest",
                200
        );
        Card card2 = new LoseCashCard(
                "Lost T-Card Fee",
                "Pay T-Card Fee, 50 Tbucks",
                "community chest",
                50
        );
        Card card3 = new GainCashCard(
                "Textbook Sale",
                "You get 50 Tbucks from your textbook sale",
                "community chest",
                50
        );
        Card card4 = new GainCashCard(
                "Computer Science Grant Awarded",
                "Comp Sci grant received, receive 100 Tbucks",
                "community chest",
                100
        );
        Card card5 = new LoseCashCard(
                "Failed Class Fee!",
                "You failed a class and have to re-take it in summer, pay 150 Tbucks",
                "community chest",
                150
        );
        Deck deck = new Deck("community chest");
        deck.putCard(card5);
        deck.putCard(card4);
        deck.putCard(card3);
        deck.putCard(card2);
        deck.putCard(card1);
        return deck;
    }

    public Deck createChanceDeck() {
        Card card1 = new GainCashCard(
                "Your friend payed you back!",
                "Friend payed you back money you forget he owed, collect 50 Tbucks",
                "chance",
                200
        );
        Card card2 = new LoseCashCard(
                "Made honor Roll",
                "You've made honor, pay 150 Tbucks",
                "chance",
                150
        );
        Card card3 = new LoseCashCard(
                "Mental Health Break",
                "You take a mental health break, pay 100 Tbucks",
                "chance",
                100
        );
        Card card4 = new GainCashCard(
                "Found Cash",
                "You find money scrunched up in the bottom of your bag, collect 100 Tbucks",
                "chance",
                100
        );
        Card card5 = new GainCashCard(
                "Parents sent money",
                "Your parents sent you money, collect 200 Tbucks",
                "chance",
                200
        );
        Deck deck = new Deck("chance");
        deck.putCard(card5);
        deck.putCard(card4);
        deck.putCard(card3);
        deck.putCard(card2);
        deck.putCard(card1);
        return deck;
    }

    public Tile[] createTileArray(Deck cChestDeck, Deck chanceDeck) {
        int boardSize = 32;
        Tile[] tiles = new Tile[boardSize];

        // Assign all the special tiles
        JailTile jailTile = new JailTile();
        tiles[0] = new StartTile();
        tiles[2] = new DrawCardTile(chanceDeck);
        tiles[4] = new DrawCardTile(cChestDeck);
        tiles[8] = new GoToJailTile(jailTile);
        tiles[12] = new DrawCardTile(chanceDeck);
        tiles[16] = new ParkingTile();
        tiles[20] = new DrawCardTile(cChestDeck);
        tiles[24] = jailTile;
        tiles[28] = new DrawCardTile(chanceDeck);
        tiles[30] = new DrawCardTile(cChestDeck);

        //Assign all property tiles, using parallel lists to store the corresponding tile parameters
        int propertyNum = 22;
        String[] nameList = new String[] {
                "Land1", "Land2", "Land3", "Land4", "Land5",
                "Land6", "Land7", "Land8", "Land9", "Land10", "Land11",
                "Land12", "Land13", "Land14", "Land15", "Land16", "Land17",
                "Land18", "Land19", "Land20", "Land21", "Land22"
        };
        String[] abbreviationList = new String[] {
                "L1", "L2", "L3", "L4", "L5",
                "L5", "L7", "L8", "L9", "L10", "L11",
                "L12", "L13", "L14", "L15", "L16", "L17",
                "L18", "L19", "L20", "L21", "L22"
        };
        int[] rent0List = new int[] {
                2, 4, 6, 6, 8,
                10, 10, 12, 14, 14, 16,
                18, 18, 20, 22, 22, 24,
                26, 26, 28, 35, 50
        };
        int[] rent1List = new int[] {
                10, 20, 30, 30, 40,
                50, 50, 60, 70, 70, 80,
                90, 90, 100, 110, 110, 120,
                130, 130, 150, 175, 200
        };
        int[] rent2List = new int[] {
                30, 60, 90, 90, 100,
                150, 150, 180, 200, 200, 220,
                250, 250, 300, 330, 330, 360,
                390, 390, 450, 500, 600
        };
        int[] rent3List = new int[] {
                90, 180, 270, 270, 300,
                450, 450, 500, 550, 550, 600,
                700, 700, 750, 800, 800, 850,
                900, 900, 1000, 1100, 1400
        };
        int[] rent4List = new int[] {
                160, 180, 400, 400, 450,
                625, 625, 700, 750, 750, 800,
                875, 875, 925, 975, 975, 1025,
                1100, 1100, 1200, 1300, 1700
        };
        int[] rent5List = new int[] {
                250, 450, 550, 550, 600,
                750, 750, 900, 950, 950, 1000,
                1050, 1050, 1100, 1150, 1150, 1200,
                1275, 1275, 1400, 1500, 2000
        };
        int[] priceList = new int[] {
                60, 60, 100, 100, 120,
                140, 140, 160, 180, 180, 200,
                220, 220, 240, 260, 260, 280,
                300, 300, 320, 400, 400
        };
        int[] housePriceList = new int[] {
                50, 50, 50, 50, 50,
                100, 100, 100, 100, 100, 100,
                150, 150, 150, 150, 150, 150,
                200, 200, 200, 200, 200
        };
        int[] hotelPriceList = new int[] {
                50, 50, 50, 50, 50,
                100, 100, 100, 100, 100, 100,
                150, 150, 150, 150, 150, 150,
                200, 200, 200, 200, 200
        };
        int[] indexList = new int[] {
                1, 3, 5, 6, 7,
                9, 10, 11, 13, 14, 15,
                17, 18, 19, 21, 22, 23,
                25, 26, 27, 29, 31
        };
        // Make properties
        NormalProperty[] propertyList = new NormalProperty[propertyNum];
        for (int i = 0; i < propertyNum; i ++) {
            int[] rentList = new int[]{
                    rent0List[i], rent1List[i], rent2List[i],
                    rent3List[i], rent4List[i], rent5List[i]
            };
            propertyList[i] = new NormalProperty(
                    rentList,
                    nameList[i],
                    abbreviationList[i],
                    priceList[i],
                    housePriceList[i],
                    hotelPriceList[i]
            );
        }

        // Put properties in Color Groups
        NormalProperty.groupProperties(propertyList[0], propertyList[1]);
        NormalProperty.groupProperties(propertyList[2], propertyList[3], propertyList[4]);
        NormalProperty.groupProperties(propertyList[5], propertyList[6], propertyList[7]);
        NormalProperty.groupProperties(propertyList[8], propertyList[9], propertyList[10]);
        NormalProperty.groupProperties(propertyList[11], propertyList[12], propertyList[13]);
        NormalProperty.groupProperties(propertyList[14], propertyList[15], propertyList[16]);
        NormalProperty.groupProperties(propertyList[17], propertyList[18], propertyList[19]);
        NormalProperty.groupProperties(propertyList[20], propertyList[21]);

        //Assign properties to property tiles
        for (int i = 0; i < propertyNum; i ++) {
            tiles[indexList[i]] = new PropertyTile(propertyList[i]);
        }

        return tiles;
    }
}

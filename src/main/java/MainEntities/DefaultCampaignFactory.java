package MainEntities;

import Cards.*;
import Properties.NormalProperty;
import Tiles.*;

import java.util.ArrayList;

public class DefaultCampaignFactory {

    /**
     * Create a campaign all at starting location with a specific number of players. The players are named p1, p2,
     * p3 ... and so on. <br>
     * Each player initially owns 1000 dollars.
     * @param playerNumber the number of players in the campaign
     * @return an initialised campaign object
     */
    public Campaign create(int playerNumber) {
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
                "Bank Error",
                "Bank error in your favor, gain 200 dollars",
                "community chest",
                200
        );
        Card card2 = new LoseCashCard(
                "Doctor's Fee",
                "Pay doctor's fee, 50 dollars",
                "community chest",
                50
        );
        Card card3 = new GainCashCard(
                "Stock Sale",
                "You get 50 dollars from stock sale",
                "community chest",
                50
        );
        Card card4 = new GainCashCard(
                "Holiday Fund",
                "Holiday fund matures, receive 100 dollars",
                "community chest",
                100
        );
        Card card5 = new LoseCashCard(
                "Doctor's Fee",
                "Pay hospital fee of 150 dollars",
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
                "Bank Dividend",
                "Bank pays you dividend of 50 dollars",
                "chance",
                200
        );
        Card card2 = new LoseCashCard(
                "Elected Chairman",
                "You've been elected chairman, pay 150 dollars",
                "chance",
                150
        );
        Card card3 = new LoseCashCard(
                "General Repair",
                "Your properties need repair, pay 100 dollars",
                "chance",
                100
        );
        Card card4 = new GainCashCard(
                "Bitcoin Investment",
                "Your investment in bitcoin profited, receive 200 dollars",
                "chance",
                200
        );
        Card card5 = new GainCashCard(
                "Life Insurance",
                "Life Insurance matures, collect 100 dollars",
                "chance",
                100
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
                "Land1",  "Land2",  "Land3",  "Land4", "Land5",
                "Land6",  "Land7",  "Land8", "Land9",  "Land10", "Land11",
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
        for (int i = 0; i < propertyNum; i ++) {
            int[] rentList = new int[]{
                    rent0List[i], rent1List[i], rent2List[i],
                    rent3List[i], rent4List[i], rent5List[i]
            };
            NormalProperty property = new NormalProperty(
                    rentList,
                    nameList[i],
                    abbreviationList[i],
                    priceList[i],
                    housePriceList[i],
                    hotelPriceList[i]
            );
            tiles[indexList[i]] = new PropertyTile(property);
        }
        return tiles;
    }
}

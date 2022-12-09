package usecase_startcampaign;

import java.util.ArrayList;
import java.util.List;

public class StartCampaignOutputData {
    private String message;
    private String nextMap;
    private int width;
    private int height;
    private int[] houseLevels;
    private int[] ownershipIndexes;
    private boolean[] mortgagedList;
    private List<String> playerNames;
    private List<Integer> playerCashes;
    private List<List<String>> playerPropertyLists;
    private List<Integer> playerLocations;
    private List<Integer> playerColors;

    public StartCampaignOutputData() {

    }

    public StartCampaignOutputData(String message,
                                   String nextMap,
                                   int width,
                                   int height,
                                   int[] houseLevels,
                                   int[] ownershipIndexes,
                                   boolean[] mortgagedList,
                                   List<String> playerNames,
                                   List<Integer> playerCashes,
                                   List<List<String>> playerPropertyLists,
                                   List<Integer> playerLocations,
                                   List<Integer> playerColors) {
        this.message = message;
        this.nextMap = nextMap;
        this.width = width;
        this.height = height;
        this.houseLevels = houseLevels.clone();
        this.ownershipIndexes = ownershipIndexes.clone();
        this.mortgagedList = mortgagedList.clone();
        this.playerNames = new ArrayList<>(playerNames);
        this.playerCashes = new ArrayList<>(playerCashes);
        this.playerPropertyLists = new ArrayList<>();
        for (List<String> list: playerPropertyLists) {
            this.playerPropertyLists.add(new ArrayList<>(list));
        }
        this.playerLocations = new ArrayList<>(playerLocations);
        this.playerColors = new ArrayList<>(playerColors);
    }

    //getters

    public String getMessage() {
        return message;
    }

    public String getNextMap() {
        return nextMap;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean[] getMortgagedList() {
        return mortgagedList;
    }

    public int[] getHouseLevels() {
        return houseLevels;
    }

    public int[] getOwnershipIndexes() {
        return ownershipIndexes;
    }

    /**
     * @return A deep copy of the array list of player property abbreviations
     */
    public ArrayList<ArrayList<String>> getPlayerPropertyLists() {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (List<String> list: playerPropertyLists) {
            result.add(new ArrayList<>(list));
        }
        return result;
    }

    public ArrayList<Integer> getPlayerCashes() {
        return new ArrayList<>(playerCashes);
    }

    public ArrayList<Integer> getPlayerLocations() {
        return new ArrayList<>(playerLocations);
    }

    public ArrayList<String> getPlayerNames() {
        return new ArrayList<>(playerNames);
    }

    public ArrayList<Integer> getPlayerColors() {
        return new ArrayList<>(playerColors);
    }

    //setters

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNextMap(String nextMap) {
        this.nextMap = nextMap;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setHouseLevels(int[] houseLevels) {
        this.houseLevels = houseLevels;
    }

    public void setMortgagedList(boolean[] mortgagedList) {
        this.mortgagedList = mortgagedList;
    }

    public void setOwnershipIndexes(int[] ownershipIndexes) {
        this.ownershipIndexes = ownershipIndexes;
    }

    public void setPlayerCashes(List<Integer> playerCashes) {
        this.playerCashes = new ArrayList<>(playerCashes);
    }

    public void setPlayerLocations(List<Integer> playerLocations) {
        this.playerLocations = new ArrayList<>(playerLocations);
    }

    public void setPlayerNames(List<String> playerNames) {
        this.playerNames = new ArrayList<>(playerNames);
    }

    public void setPlayerPropertyLists(List<ArrayList<String>> playerPropertyLists) {
        this.playerPropertyLists = new ArrayList<>();
        for (List<String> list: playerPropertyLists) {
            this.playerPropertyLists.add(new ArrayList<>(list));
        }
    }

    public void setPlayerColors(List<Integer> playerColors) {
        this.playerColors = new ArrayList<>(playerColors);
    }
}

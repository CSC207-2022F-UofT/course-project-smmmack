package BuildHouseUseCase;

import Properties.Property;

public class BuildHouseInputData {

    int playerIndexBuilds;
    Property property;
    int numberOfHouse;


    public BuildHouseInputData(int playerIndexBuilds, Property property, int numberOfHouse){

        this.playerIndexBuilds = playerIndexBuilds;
        this.property = property;
        this.numberOfHouse = numberOfHouse;
    }

    public int getPlayerIndexBuilds() {
        return playerIndexBuilds;
    }

    public void setPlayerIndexBuilds(int playerIndexBuilds) {
        this.playerIndexBuilds = playerIndexBuilds;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public int getNumberOfHouse() {
        return numberOfHouse;
    }

    public void setNumberOfHouse(int numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }
}

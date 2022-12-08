package BuildHouseUseCase;

import Properties.Property;

public class BuildHouseInputData {
    String property;
    int numberOfHouse;

    /**
     *
     * @param property The property's abbreviation selected by the current player to build house(s) on.
     * @param numberOfHouse The integer amount indicating the number of house(s) the
     *                      player wants to build on the selected property.
     */


    public BuildHouseInputData(String property, int numberOfHouse){

        this.property = property;
        this.numberOfHouse = numberOfHouse;
    }


    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public int getNumberOfHouse() {
        return numberOfHouse;
    }

    public void setNumberOfHouse(int numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }
}
